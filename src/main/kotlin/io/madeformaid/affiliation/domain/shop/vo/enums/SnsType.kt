package io.madeformaid.affiliation.domain.shop.vo.enums

import io.madeformaid.shared.vo.enums.DescribableEnum

enum class SnsType(
        private val displayName: String,
) : DescribableEnum {
    INSTAGRAM("인스타그램"),
    X("엑스(트위터)"),
    NAVER("네이버"),
    YOUTUBE("유튜브"),
    TIKTOK("틱톡"),
    ;

    override fun getDisplayName(): String = displayName
}
