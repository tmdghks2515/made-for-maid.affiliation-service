package io.madeformaid.affiliation.domain.shop.repository

import io.madeformaid.affiliation.domain.shop.entity.ShopEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ShopRepository : JpaRepository<ShopEntity, String> {
    fun findByNameLike(name: String): List<ShopEntity>
    fun existsByName(name: String): Boolean
}
