package io.madeformaid.affiliation.domain.cafe.entity

import io.madeformaid.affiliation.domain.cafe.vo.enums.CafeConceptType
import io.madeformaid.shared.jpa.converter.EnumListConverter
import jakarta.persistence.Converter

@Converter
class ConceptTypeListConverter : EnumListConverter<CafeConceptType>(CafeConceptType::class.java)
