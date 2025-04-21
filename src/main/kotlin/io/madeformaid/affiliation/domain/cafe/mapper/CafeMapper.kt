package io.madeformaid.affiliation.domain.cafe.mapper

import io.madeformaid.affiliation.domain.cafe.dto.data.CafeDTO
import io.madeformaid.affiliation.domain.cafe.entity.CafeEntity
import org.springframework.stereotype.Component

@Component
class CafeMapper(
        private val snsLinkMapper: SnsLinkMapper
) {
    fun toEntity(dto: CafeDTO): CafeEntity {
        return CafeEntity(
                id = dto.id,
                name = dto.name,
                contactNumber = dto.contactNumber,
                cafeConceptTypes = dto.cafeConceptTypes.toMutableList(),
                menuImageUrls = dto.menuImageUrls.toMutableList(),
                snsLinks = dto.snsLinks.map { snsLinkMapper.toEntity(it) }.toMutableList(),
        )
    }

    fun toDTO(entity: CafeEntity): CafeDTO {
        return CafeDTO(
                id = entity.id,
                name = entity.name,
                contactNumber = entity.contactNumber,
                cafeConceptTypes = entity.cafeConceptTypes,
                menuImageUrls = entity.menuImageUrls,
                snsLinks = entity.snsLinks.map { snsLinkMapper.toDto(it) },
                createdAt = entity.createdAt
        )
    }
}
