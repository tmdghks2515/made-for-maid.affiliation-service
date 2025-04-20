package io.madeformaid.affiliation.domain.affiliation.entity

import io.madeformaid.affiliation.domain.cafe.entity.CafeEntity
import io.madeformaid.shared.jpa.entity.BaseEntity
import io.madeformaid.shared.jpa.idGenerator.ShortId
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "affiliation")
class AffiliationEntity(
        @Id
        @ShortId
        var id: String? = null,

        @Column(name = "cafe_id", nullable = false)
        val cafeId: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "cafe_id", insertable = false, updatable = false)
        var cafe: CafeEntity? = null,

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
            cafeId = "",
            cafe = null,
            startAt = LocalDateTime.now(),
            expiryAt = LocalDateTime.now()
    )
}
