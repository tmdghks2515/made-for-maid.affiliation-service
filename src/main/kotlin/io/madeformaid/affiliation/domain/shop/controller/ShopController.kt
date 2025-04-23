package io.madeformaid.affiliation.domain.shop.controller

import io.madeformaid.affiliation.domain.shop.dto.data.ShopDTO
import io.madeformaid.affiliation.domain.shop.service.ShopService
import io.madeformaid.shared.dto.ValueLabelDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/affiliation/shop")
class ShopController(
    private val shopService: ShopService,
) {
    @PostMapping
    fun createShop(@RequestBody shopDTO: ShopDTO): ResponseEntity<ShopDTO> {
        return ResponseEntity.ok(shopService.createShop(shopDTO))
    }

    @GetMapping("/autocomplete")
    fun autoCompleteSearch(keyword: String): ResponseEntity<List<ValueLabelDTO>> {
        return ResponseEntity.ok(shopService.autoCompleteSearch(keyword))
    }
}
