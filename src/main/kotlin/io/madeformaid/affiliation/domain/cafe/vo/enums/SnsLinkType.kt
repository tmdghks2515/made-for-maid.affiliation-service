package io.madeformaid.affiliation.domain.cafe.vo.enums

import io.madeformaid.shared.vo.enums.DescribableEnum

enum class SnsLinkType(
        private val displayName: String,
) : DescribableEnum {
    CAFE_LINK("업체 링크"),
    STAFF_LINK("메이드/집사 링크"),
    ;

    override fun getDisplayName(): String = displayName
}
