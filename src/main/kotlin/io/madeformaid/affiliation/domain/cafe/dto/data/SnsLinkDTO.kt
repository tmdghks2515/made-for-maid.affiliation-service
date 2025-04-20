package io.madeformaid.affiliation.domain.cafe.dto.data

import io.madeformaid.affiliation.domain.cafe.vo.enums.SnsLinkType
import io.madeformaid.affiliation.domain.cafe.vo.enums.SnsType

data class SnsLinkDTO(
        val id: String?,
        val cafeId: String?,
        val staffId: String?,
        val linkType: SnsLinkType,
        val snsType: SnsType,
        val linkUrl: String,
        val displayOrder: Int,
)
