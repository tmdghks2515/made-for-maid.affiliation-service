package io.madeformaid.affiliation.domain.cafe.mapper

import io.madeformaid.affiliation.domain.cafe.dto.data.SnsLinkDTO
import io.madeformaid.affiliation.domain.cafe.entity.SnsLinkEntity
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
            cafeId = snsLinkEntity.cafe?.id,
            staffId = snsLinkEntity.staffId,
            linkType = snsLinkEntity.linkType,
            snsType = snsLinkEntity.snsType,
            linkUrl = snsLinkEntity.linkUrl,
            displayOrder = snsLinkEntity.displayOrder
        )
    }
}
