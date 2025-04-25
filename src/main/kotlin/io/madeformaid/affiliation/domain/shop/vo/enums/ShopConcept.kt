package io.madeformaid.affiliation.domain.shop.vo.enums

import io.madeformaid.shared.vo.enums.DescribableEnum

enum class ShopConcept(
        private val displayName: String,
) : DescribableEnum {
    SHOP_CONCEPT_MAID("메이드"),
    SHOP_CONCEPT_BUTLER("버틀러"),
    SHOP_CONCEPT_ANIMAL("동물"),
    SHOP_CONCEPT_SCHOOL("교복"),
    SHOP_CONCEPT_DEMON("악마"),
    SHOP_CONCEPT_ANGEL("천사"),
    SHOP_CONCEPT_GANG("불량/양아치"),
    SHOP_CONCEPT_TSUNDERE("츤데레"),
    SHOP_CONCEPT_YANDERE("얀데레"),
    SHOP_CONCEPT_FANTASY("판타지"),
    SHOP_CONCEPT_IDOL("아이돌"),
    SHOP_CONCEPT_HOSPITAL("병원"),
    SHOP_CONCEPT_GOTHIC("고딕"),
    SHOP_CONCEPT_BLGL("BL/GL"),
    SHOP_CONCEPT_BIG("빅"),
    SHOP_CONCEPT_SMALL("스몰"),
    SHOP_CONCEPT_MUSCLE("머슬"),
    SHOP_CONCEPT_OTHER("기타"),
    ;

    override fun getDisplayName(): String = displayName
}
