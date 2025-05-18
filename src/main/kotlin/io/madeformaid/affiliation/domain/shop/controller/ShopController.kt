package io.madeformaid.affiliation.domain.shop.controller

import io.madeformaid.affiliation.domain.shop.dto.command.UpdateShopConceptsCommand
import io.madeformaid.affiliation.domain.shop.dto.command.UpdateShopMenuImagesCommand
import io.madeformaid.affiliation.domain.shop.dto.command.UpdateShopNameCommand
import io.madeformaid.affiliation.domain.shop.dto.command.UpdateShopSnsLinksCommand
import io.madeformaid.affiliation.domain.shop.dto.data.ShopDTO
import io.madeformaid.affiliation.domain.shop.service.ShopQueryService
import io.madeformaid.affiliation.domain.shop.service.ShopService
import io.madeformaid.shared.dto.ValueLabelDTO
import io.madeformaid.webmvc.context.AuthContext
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/affiliation/shop")
class ShopController(
    private val shopService: ShopService,
    private val shopQueryService: ShopQueryService
) {
    @PostMapping
    fun createShop(@RequestBody shopDTO: ShopDTO): ResponseEntity<ShopDTO> {
        return ResponseEntity.ok(shopService.createShop(shopDTO))
    }

    @GetMapping("/autocomplete")
    fun autoCompleteSearch(keyword: String): ResponseEntity<List<ValueLabelDTO>> {
        return ResponseEntity.ok(shopQueryService.autoCompleteSearch(keyword))
    }

    @PutMapping("/update/name")
    fun updateShopName(@RequestBody command: UpdateShopNameCommand): ResponseEntity<ShopDTO> {
        return ResponseEntity.ok(shopService.updateShopName(command))
    }

    @PutMapping("/update/concepts")
    fun updateShopConcepts(@RequestBody command: UpdateShopConceptsCommand): ResponseEntity<ShopDTO> {
        return ResponseEntity.ok(shopService.updateShopConcepts(command))
    }

    @PutMapping("/update/menu-images")
    fun updateShopMenuImages(@RequestBody command: UpdateShopMenuImagesCommand): ResponseEntity<ShopDTO> {
        return ResponseEntity.ok(shopService.updateMenuImages(command))
    }

    @PutMapping("/update/sns-links")
    fun updateShopSnsLinks(@RequestBody command: UpdateShopSnsLinksCommand): ResponseEntity<ShopDTO> {
        return ResponseEntity.ok(shopService.updateShopSnsLinks(command))
    }

    @GetMapping
    fun getShopDetail(): ResponseEntity<ShopDTO> {
        val shopId = AuthContext.getShopId()
            ?: error("Shop ID is required")
        return ResponseEntity.ok(shopQueryService.getShopDetail(shopId))
    }
}
