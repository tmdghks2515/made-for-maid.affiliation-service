package io.madeformaid.affiliation.domain.shop.mapper

import io.madeformaid.affiliation.domain.shop.dto.data.SnsLinkDTO
import io.madeformaid.affiliation.domain.shop.entity.SnsLinkEntity
import org.springframework.stereotype.Component

@Component
class SnsLinkMapper {
    fun toEntity(snsLinkDTO: SnsLinkDTO): SnsLinkEntity {
        return SnsLinkEntity(
            id = snsLinkDTO.id,
            staffId = snsLinkDTO.staffId,
            linkType = snsLinkDTO.linkType,
            snsType = snsLinkDTO.snsType,
            linkUrl = snsLinkDTO.linkUrl,
            displayOrder = snsLinkDTO.displayOrder,
        )
    }

    fun toDto(snsLinkEntity: SnsLinkEntity): SnsLinkDTO {
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
