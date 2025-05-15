package io.madeformaid.affiliation.domain.shop.entity

import io.madeformaid.webmvc.jpa.idGenerator.ShortId
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "shop_menu_image")
class ShopMenuImageEntity(
    @Id
    @ShortId
    val id: String? = null,

    @ManyToOne
    val shop: ShopEntity,

    @Column(name = "image_id", nullable = false)
    val imageId: String,

    @Column(name = "image_url", nullable = false)
    val imageUrl: String,

    var displayOrder: Int = 0,
) {
    constructor() : this(
        shop = ShopEntity(),
        imageId = "",
        imageUrl = "",
    )
}

