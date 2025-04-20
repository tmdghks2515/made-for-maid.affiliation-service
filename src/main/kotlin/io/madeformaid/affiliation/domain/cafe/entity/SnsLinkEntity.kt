package io.madeformaid.affiliation.domain.cafe.entity

import io.madeformaid.affiliation.domain.cafe.vo.enums.SnsType
import io.madeformaid.affiliation.domain.cafe.vo.enums.SnsLinkType
import io.madeformaid.shared.jpa.entity.BaseEntity
import io.madeformaid.shared.jpa.idGenerator.ShortId
import jakarta.persistence.Column
import jakarta.persistence.Entity
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

        @Column(name = "cafe_id")
        val cafeId: String? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "cafe_id", insertable = false, updatable = false)
        var cafe: CafeEntity? = null,

        @Column(name = "staff_id")
        val staffId: String? = null,

        @Column(name = "link_type", nullable = false)
        val linkType: SnsLinkType,

        @Column(name = "sns_type", nullable = false)
        var snsType: SnsType,

        @Column(name = "link_url", nullable = false, length = 1000)
        var linkUrl: String,

        @Column(name = "display_order", nullable = false)
        var displayOrder: Int = 0,
) : BaseEntity() {
        protected constructor() : this(
            linkType = SnsLinkType.CAFE_LINK,
            snsType = SnsType.INSTAGRAM,
            linkUrl = "",
    )
}
