package io.madeformaid.affiliation.domain.shop.dto.data

data class ShopMenuImageDTO(
    val id: String?,
    val imageId: String,
    val imageUrl: String,
    val displayOrder: Int = 0,
)
