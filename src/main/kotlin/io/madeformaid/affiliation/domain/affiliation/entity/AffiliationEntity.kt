package io.madeformaid.affiliation.domain.affiliation.entity

import io.madeformaid.affiliation.domain.shop.entity.ShopEntity
import io.madeformaid.webmvc.jpa.entity.BaseEntity
import io.madeformaid.webmvc.jpa.idGenerator.ShortId
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "affiliation")
class AffiliationEntity(
        @Id
        @ShortId
        var id: String? = null,

        @Column(name = "shop_id", nullable = false)
        val shopId: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "shop_id", insertable = false, updatable = false)
        var shop: ShopEntity? = null,

        @Column(name = "payment_id", nullable = false)
        val paymentId: String,

        @Column(name = "start_at", nullable = false)
        val startAt: LocalDateTime,

        @Column(name = "expiry_at", nullable = false)
        val expiryAt: LocalDateTime,
) : BaseEntity() {
    protected constructor() : this(
            id = null,
            paymentId = "",
            shopId = "",
            shop = null,
            startAt = LocalDateTime.now(),
            expiryAt = LocalDateTime.now()
    )
}
