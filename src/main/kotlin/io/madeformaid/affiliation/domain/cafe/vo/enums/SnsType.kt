package io.madeformaid.affiliation.domain.cafe.vo.enums

import io.madeformaid.shared.vo.enums.DescribableEnum

enum class SnsType(
        private val displayName: String,
) : DescribableEnum {
    INSTAGRAM("인스타그램"),
    X("엑스(트위터)"),
    NAVER_CAFE("네이버 카페"),
    ;

    override fun getDisplayName(): String = displayName
}
