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
                shopConcepts = dto.shopConcepts.toMutableList(),
                menuImageUrls = dto.menuImageUrls
                    .filter { it.isNotBlank() }
                    .toMutableList(),
                snsLinks = dto.snsLinks
                    .filter { it.linkUrl.isNotBlank() }
                    .map { snsLinkMapper.toEntity(it) }.toMutableList(),
        )
    }

    fun toDTO(entity: ShopEntity): ShopDTO {
        return ShopDTO(
                id = entity.id,
                name = entity.name,
                contactNumber = entity.contactNumber,
                shopConcepts = entity.shopConcepts,
                menuImageUrls = entity.menuImageUrls,
                snsLinks = entity.snsLinks.map { snsLinkMapper.toDto(it) },
                createdAt = entity.createdAt
        )
    }
}
