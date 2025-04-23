package io.madeformaid.affiliation.domain.shop.vo.enums

import io.madeformaid.shared.vo.enums.DescribableEnum

enum class ShopConceptType(
        private val displayName: String,
) : DescribableEnum {
    MAID("메이드"),
    BUTLER("버틀러"),
    ANIMAL("동물"),
    SCHOOL("교복"),
    DEMON("악마"),
    ANGEL("천사"),
    GANG("불량/양아치"),
    TSUNDERE("츤데레"),
    YANDERE("얀데레"),
    FANTASY("판타지"),
    IDOL("아이돌"),
    HOSPITAL("병원"),
    GOTHIC("고딕"),
    BLGL("BL/GL"),
    BIG("빅"),
    SMALL("스몰"),
    MUSCLE("머슬"),
    OTHER("기타"),
    ;

    override fun getDisplayName(): String = displayName
}
