package io.madeformaid.affiliation.domain.shop.mapper

import io.madeformaid.affiliation.domain.shop.dto.data.SnsLinkDTO
import io.madeformaid.affiliation.domain.shop.entity.ShopEntity
import io.madeformaid.affiliation.domain.shop.entity.SnsLinkEntity

object SnsLinkMapper {
    fun toEntity(snsLinkDTO: SnsLinkDTO, shop: ShopEntity): SnsLinkEntity {
        return SnsLinkEntity(
            id = snsLinkDTO.id,
            staffId = snsLinkDTO.staffId,
            linkType = snsLinkDTO.linkType,
            snsType = snsLinkDTO.snsType,
            linkUrl = snsLinkDTO.linkUrl,
            displayOrder = snsLinkDTO.displayOrder,
            shop = shop
        )
    }

    fun toDTO(snsLinkEntity: SnsLinkEntity): SnsLinkDTO {
        return SnsLinkDTO(
            id = snsLinkEntity.id,
            shopId = snsLinkEntity.shop?.id,
            staffId = snsLinkEntity.staffId,
            linkType = snsLinkEntity.linkType,
            snsType = snsLinkEntity.snsType,
            linkUrl = snsLinkEntity.linkUrl,
            displayOrder = snsLinkEntity.displayOrder
        )
    }
}
