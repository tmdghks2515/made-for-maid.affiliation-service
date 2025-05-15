package io.madeformaid.affiliation.domain.shop.dto.command

import io.madeformaid.affiliation.domain.shop.dto.data.ShopMenuImageDTO
import io.madeformaid.affiliation.domain.shop.vo.enums.ShopConcept

data class UpdateShopNameCommand(
    val shopId: String,
    val newName: String,
)

data class UpdateShopMenuImagesCommand(
    val shopId: String,
    val newMenus: List<ShopMenuImageDTO>,
)

data class UpdateShopConceptsCommand(
    val shopId: String,
    val newShopConcepts: Set<ShopConcept>,
)