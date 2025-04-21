package io.madeformaid.affiliation.domain.cafe.repository

import io.madeformaid.affiliation.domain.cafe.entity.CafeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CafeRepository : JpaRepository<CafeEntity, String> {
    fun findByNameLike(name: String): List<CafeEntity>
    fun existsByName(name: String): Boolean
}
