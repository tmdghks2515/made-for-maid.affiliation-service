package io.madeformaid.affiliation.domain.cafe.dto.data

import io.madeformaid.affiliation.domain.cafe.vo.enums.CafeConceptType
import java.time.LocalDateTime

data class CafeDTO(
        val id: String?,
        val name: String,
        val contactNumber: String,
        val cafeConceptTypes: List<CafeConceptType>,
        val menuImageUrls: List<String>,
        val snsLinks: List<SnsLinkDTO>,
        val createdAt: LocalDateTime?,
)
