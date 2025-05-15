package io.madeformaid.affiliation.domain.shop.mapper

import io.madeformaid.affiliation.domain.shop.dto.data.ShopDTO
import io.madeformaid.affiliation.domain.shop.entity.ShopEntity
import org.springframework.stereotype.Component

object ShopMapper {
    fun toEntity(dto: ShopDTO): ShopEntity {
        val shopEntity = ShopEntity(
                id = dto.id,
                name = dto.name,
                contactNumber = dto.contactNumber,
                shopConcepts = dto.shopConcepts.toMutableList(),
        )

        shopEntity.snsLinks.addAll(
            dto.snsLinks
                .filter { it.linkUrl.isNotBlank() }
                .map { SnsLinkMapper.toEntity(it, shopEntity) }
                .toMutableList()
        )

        shopEntity.menuImages.addAll(
            dto.menuImages
                .filter { it.imageUrl.isNotBlank() && it.imageId.isNotBlank() }
                .map { ShopMenuImageMapper.toEntity(it, shopEntity) }
                .toMutableList()
        )

        return shopEntity
    }

    fun toDTO(entity: ShopEntity): ShopDTO {
        return ShopDTO(
                id = entity.id,
                name = entity.name,
                contactNumber = entity.contactNumber,
                shopConcepts = entity.shopConcepts,
                menuImages = entity.menuImages.map { ShopMenuImageMapper.toDTO(it) },
                snsLinks = entity.snsLinks.map { SnsLinkMapper.toDTO(it) },
                createdAt = entity.createdAt
        )
    }
}
