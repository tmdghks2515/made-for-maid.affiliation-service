package io.madeformaid.affiliation.domain.shop.entity

import io.madeformaid.affiliation.domain.shop.vo.enums.ShopConcept
import io.madeformaid.webmvc.jpa.converter.EnumListConverter
import jakarta.persistence.Converter

@Converter
class ShopConceptListConverter : EnumListConverter<ShopConcept>(ShopConcept::class.java)
