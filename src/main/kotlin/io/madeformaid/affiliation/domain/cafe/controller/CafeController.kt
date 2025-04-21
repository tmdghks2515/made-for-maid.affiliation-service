package io.madeformaid.affiliation.domain.cafe.controller

import io.madeformaid.affiliation.domain.cafe.dto.data.CafeDTO
import io.madeformaid.affiliation.domain.cafe.service.CafeService
import io.madeformaid.shared.dto.ValueLabelDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/affiliation/cafe")
class CafeController(
        private val cafeService: CafeService,
) {
    @PostMapping
    fun createCafe(@RequestBody cafeDTO: CafeDTO): ResponseEntity<CafeDTO> {
        return ResponseEntity.ok(cafeService.createCafe(cafeDTO))
    }

    @GetMapping("/autocomplete")
    fun autoCompleteSearch(keyword: String): ResponseEntity<List<ValueLabelDTO>> {
        return ResponseEntity.ok(cafeService.autoCompleteSearch(keyword))
    }
}
