package io.madeformaid.affiliation.domain.shop.service

import event.ImageEvent
import event.ImageEvent.ImageUnusingEvents
import event.ImageEvent.ImageUsingEvents
import io.madeformaid.affiliation.domain.shop.dto.command.UpdateShopConceptsCommand
import io.madeformaid.affiliation.domain.shop.dto.command.UpdateShopMenuImagesCommand
import io.madeformaid.affiliation.domain.shop.dto.command.UpdateShopNameCommand
import io.madeformaid.affiliation.domain.shop.dto.data.ShopDTO
import io.madeformaid.affiliation.domain.shop.mapper.ShopMapper
import io.madeformaid.affiliation.domain.shop.mapper.ShopMenuImageMapper
import io.madeformaid.affiliation.domain.shop.repository.ShopRepository
import io.madeformaid.affiliation.global.event.publisher.ImageEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ShopService(
    private val shopRepository: ShopRepository,
    private val imageEventPublisher: ImageEventPublisher
) {
    fun createShop(shopDTO: ShopDTO) : ShopDTO {
        if (shopRepository.existsByName(shopDTO.name)) {
            throw IllegalArgumentException("'${shopDTO.name}'은 이미 사용 중인 이름입니다. 다른 이름을 입력해주세요.")
        }

        val shopEntity = ShopMapper.toEntity(shopDTO)
        val savedShopEntity = shopRepository.save(shopEntity)

        savedShopEntity.menuImages.takeIf {  it.isNotEmpty() }?.let {
            imageEventPublisher.publishImagesUsing(
                event = ImageUsingEvents.newBuilder()
                    .addAllEvents(
                        it.map { menuImage ->
                            ImageEvent.ImageUsingEvent.newBuilder()
                                .setImageId(menuImage.imageId)
                                .setUsedByType(ImageEvent.UploadImageType.SHOP_MENU)
                                .setUsedById(menuImage.imageId)
                                .build()
                        }
                    )
                    .build(),
                usedById = savedShopEntity.id ?: error("Shop ID is null")
            )
        }

        return ShopMapper.toDTO(savedShopEntity)
    }

    fun updateShopName(command: UpdateShopNameCommand): ShopDTO {
        val (shopId, newName) = command

        val shopEntity = shopRepository.findById(shopId)
            .orElseThrow { IllegalArgumentException("Shop with ID $shopId not found") }

        if (shopRepository.existsByName(newName)) {
            throw IllegalArgumentException("'$newName'은 이미 사용 중인 이름입니다. 다른 이름을 입력해주세요.")
        }

        shopEntity.name = newName
        val updatedShopEntity = shopRepository.save(shopEntity)
        return ShopMapper.toDTO(updatedShopEntity)
    }

    fun updateShopConcepts(command: UpdateShopConceptsCommand): ShopDTO {
        val (shopId, newConcepts) = command

        val shopEntity = shopRepository.findById(shopId)
            .orElseThrow { IllegalArgumentException("Shop with ID $shopId not found") }

        shopEntity.shopConcepts = newConcepts.toMutableList()
        val updatedShopEntity = shopRepository.save(shopEntity)
        return ShopMapper.toDTO(updatedShopEntity)
    }

    fun updateMenuImages(command: UpdateShopMenuImagesCommand): ShopDTO {
        val (shopId, menuImages) = command

        val shopEntity = shopRepository.findById(shopId)
            .orElseThrow { IllegalArgumentException("Shop with ID $shopId not found") }

        val validMenuImages = menuImages.filter {
            it.imageUrl.isNotBlank() && it.imageId.isNotBlank()
        }

        val removedImageIds = mutableListOf<String>()
        val newlyUsingImageIds = mutableListOf<String>()
        val previousImageIds = shopEntity.menuImages.map { it.imageId }
        val newImageIds = validMenuImages.map { it.imageId }

        shopEntity.menuImages.forEach { menuImage ->
            if (menuImage.imageId !in newImageIds) {
                removedImageIds.add(menuImage.imageId)
            }
        }
        validMenuImages.forEach { menuImage ->
            if (menuImage.imageId !in previousImageIds) {
                newlyUsingImageIds.add(menuImage.imageId)
            }
        }

        shopEntity.menuImages.clear()
        shopEntity.menuImages.addAll(
            validMenuImages
                .map { ShopMenuImageMapper.toEntity(it, shopEntity) }
        )

        val updatedShopEntity = shopRepository.save(shopEntity)

        if (removedImageIds.isNotEmpty()) {
            imageEventPublisher.publishImagesUsing(
                event = ImageUsingEvents.newBuilder()
                    .addAllEvents(
                        removedImageIds.map { imageId ->
                            ImageEvent.ImageUsingEvent.newBuilder()
                                .setImageId(imageId)
                                .setUsedByType(ImageEvent.UploadImageType.SHOP_MENU)
                                .setUsedById(shopEntity.id ?: error("Shop ID is null"))
                                .build()
                        }
                    )
                    .build(),
                usedById = shopEntity.id ?: error("Shop ID is null")
            )

            imageEventPublisher.publishImagesUnusing(
                event = ImageUnusingEvents.newBuilder()
                    .addAllEvents(
                        removedImageIds.map { imageId ->
                            ImageEvent.ImageUnusingEvent.newBuilder()
                                .setImageId(imageId)
                                .build()
                        }
                    )
                    .build(),
                usedById = shopEntity.id ?: error("Shop ID is null")
            )
        }

        return ShopMapper.toDTO(updatedShopEntity)
    }
}
