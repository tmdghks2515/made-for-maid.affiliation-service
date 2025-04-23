package io.madeformaid.affiliation.domain.shop.entity

import io.madeformaid.affiliation.domain.shop.vo.enums.SnsType
import io.madeformaid.affiliation.domain.shop.vo.enums.SnsLinkType
import io.madeformaid.webmvc.jpa.entity.BaseEntity
import io.madeformaid.webmvc.jpa.idGenerator.ShortId
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "sns_link")
class SnsLinkEntity(
        @Id
        @ShortId
        var id: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "shop_id", updatable = false)
        var shop: ShopEntity? = null,

        @Column(name = "staff_id")
        val staffId: String? = null,

        @Enumerated(EnumType.STRING)
        @Column(name = "link_type", nullable = false, columnDefinition = "varchar(100)")
        val linkType: SnsLinkType,

        @Enumerated(EnumType.STRING)
        @Column(name = "sns_type", nullable = false, columnDefinition = "varchar(100)")
        var snsType: SnsType,

        @Column(name = "link_url", nullable = false, length = 1000)
        var linkUrl: String,

        @Column(name = "display_order", nullable = false)
        var displayOrder: Int = 0,
) : BaseEntity() {
        protected constructor() : this(
            linkType = SnsLinkType.SHOP_LINK,
            snsType = SnsType.INSTAGRAM,
            linkUrl = "",
    )
}
