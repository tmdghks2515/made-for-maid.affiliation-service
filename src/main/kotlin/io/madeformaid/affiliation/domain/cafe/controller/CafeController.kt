package io.madeformaid.affiliation.domain.cafe.controller

import io.madeformaid.affiliation.domain.cafe.dto.data.CafeDTO
import io.madeformaid.affiliation.domain.cafe.service.CafeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class CafeController(
        private val cafeService: CafeService,
) {
    fun createCafe(cafeDTO: CafeDTO): ResponseEntity<CafeDTO> {
        return ResponseEntity.ok(cafeService.createCafe(cafeDTO))
    }
}
