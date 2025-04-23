package io.madeformaid.affiliation.domain.shop.entity

import io.madeformaid.affiliation.domain.shop.vo.enums.ShopConceptType
import io.madeformaid.webmvc.jpa.converter.EnumListConverter
import jakarta.persistence.Converter

@Converter
class ShopConceptTypeListConverter : EnumListConverter<ShopConceptType>(ShopConceptType::class.java)
