package io.madeformaid.affiliation.domain.shop.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.madeformaid.affiliation.domain.shop.vo.enums.ShopConceptType
import io.madeformaid.webmvc.jpa.converter.StringListConverter
import io.madeformaid.webmvc.jpa.entity.BaseEntity
import io.madeformaid.webmvc.jpa.idGenerator.ShortId
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.Id
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

        @Column(name = "shop_concept_types")
        @Convert(converter = ShopConceptTypeListConverter::class)
        val shopConceptTypes: MutableList<ShopConceptType> = mutableListOf(),

        @Column(name = "menu_image_urls", length = 1000)
        @Convert(converter = StringListConverter::class)
        val menuImageUrls: MutableList<String> = mutableListOf(),

        @JsonIgnoreProperties(value = ["shop"])
        @OneToMany(mappedBy = "shop", cascade = [CascadeType.ALL], orphanRemoval = true)
        val snsLinks: MutableList<SnsLinkEntity> = mutableListOf()
) : BaseEntity() {
        protected constructor() : this(
                id = null,
                name = "",
                contactNumber = "",
        )

        fun addAssociations() {
                snsLinks.forEach {
                        it.shop = this
                }
        }
}
