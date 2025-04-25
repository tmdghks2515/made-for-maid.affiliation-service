package io.madeformaid.affiliation.domain.shop.dto.data

import io.madeformaid.affiliation.domain.shop.vo.enums.ShopConcept
import java.time.LocalDateTime

data class ShopDTO(
        val id: String?,
        val name: String,
        val contactNumber: String,
        val shopConcepts: List<ShopConcept>,
        val menuImageUrls: List<String>,
        val snsLinks: List<SnsLinkDTO>,
        val createdAt: LocalDateTime?,
)
