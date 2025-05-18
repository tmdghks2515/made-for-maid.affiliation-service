package io.madeformaid.affiliation.domain.shop.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.madeformaid.affiliation.domain.shop.vo.enums.ShopConcept
import io.madeformaid.webmvc.jpa.converter.StringListConverter
import io.madeformaid.webmvc.jpa.entity.BaseEntity
import io.madeformaid.webmvc.jpa.idGenerator.ShortId
import jakarta.persistence.CascadeType
import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "shop")
class ShopEntity(
        @Id
        @ShortId
        var id: String? = null,

        @Column(name = "name", nullable = false, unique = true, length = 30)
        var name: String,

        @Column(name = "contact_number", length = 20)
        var contactNumber: String,

        @ElementCollection(fetch = FetchType.LAZY)
        @CollectionTable(
                name = "shop_concept",
                joinColumns = [JoinColumn(name = "shop_id")]
        )
        @Enumerated(EnumType.STRING)
        @Column(name = "shop_concept", columnDefinition = "varchar(100)")
        var shopConcepts: MutableList<ShopConcept> = mutableListOf(),

        @Column(name = "menu_image_urls")
        @OneToMany(mappedBy = "shop", cascade = [CascadeType.ALL], orphanRemoval = true)
        val menuImages: MutableList<ShopMenuImageEntity> = mutableListOf(),

        @JsonIgnoreProperties(value = ["shop"])
        @OneToMany(mappedBy = "shop", cascade = [CascadeType.ALL], orphanRemoval = true)
        val snsLinks: MutableList<SnsLinkEntity> = mutableListOf()
) : BaseEntity() {
        constructor() : this(
                id = null,
                name = "",
                contactNumber = "",
        )
}
