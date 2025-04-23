package io.madeformaid.affiliation.domain.shop.dto.data

import io.madeformaid.affiliation.domain.shop.vo.enums.SnsLinkType
import io.madeformaid.affiliation.domain.shop.vo.enums.SnsType

data class SnsLinkDTO(
        val id: String?,
        val shopId: String?,
        val staffId: String?,
        val linkType: SnsLinkType,
        val snsType: SnsType,
        val linkUrl: String,
        val displayOrder: Int,
)
