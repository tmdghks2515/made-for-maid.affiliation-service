package io.madeformaid.affiliation.domain.shop.mapper

import io.madeformaid.affiliation.domain.shop.dto.data.ShopDTO
import io.madeformaid.affiliation.domain.shop.entity.ShopEntity
import org.springframework.stereotype.Component

@Component
class ShopMapper(
        private val snsLinkMapper: SnsLinkMapper
) {
    fun toEntity(dto: ShopDTO): ShopEntity {
        return ShopEntity(
                id = dto.id,
                name = dto.name,
                contactNumber = dto.contactNumber,
                shopConceptTypes = dto.shopConceptTypes.toMutableList(),
                menuImageUrls = dto.menuImageUrls.toMutableList(),
                snsLinks = dto.snsLinks.map { snsLinkMapper.toEntity(it) }.toMutableList(),
        )
    }

    fun toDTO(entity: ShopEntity): ShopDTO {
        return ShopDTO(
                id = entity.id,
                name = entity.name,
                contactNumber = entity.contactNumber,
                shopConceptTypes = entity.shopConceptTypes,
                menuImageUrls = entity.menuImageUrls,
                snsLinks = entity.snsLinks.map { snsLinkMapper.toDto(it) },
                createdAt = entity.createdAt
        )
    }
}
