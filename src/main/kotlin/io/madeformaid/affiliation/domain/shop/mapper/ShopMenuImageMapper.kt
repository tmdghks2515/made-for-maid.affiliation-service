package io.madeformaid.affiliation.domain.shop.mapper

import io.madeformaid.affiliation.domain.shop.dto.data.ShopMenuImageDTO
import io.madeformaid.affiliation.domain.shop.entity.ShopEntity
import io.madeformaid.affiliation.domain.shop.entity.ShopMenuImageEntity

object ShopMenuImageMapper {
    fun toDTO(entity: ShopMenuImageEntity): ShopMenuImageDTO = ShopMenuImageDTO(
        id = entity.id,
        imageId = entity.imageId,
        imageUrl = entity.imageUrl,
        displayOrder = entity.displayOrder
    )

    fun toEntity(dto: ShopMenuImageDTO, shop: ShopEntity): ShopMenuImageEntity = ShopMenuImageEntity(
        id = dto.id,
        shop = shop,
        imageId = dto.imageId,
        imageUrl = dto.imageUrl,
        displayOrder = dto.displayOrder,
    )
}