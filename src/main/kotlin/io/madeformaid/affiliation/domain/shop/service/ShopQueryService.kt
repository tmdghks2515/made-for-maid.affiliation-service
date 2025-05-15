package io.madeformaid.affiliation.domain.shop.service

import io.madeformaid.affiliation.domain.shop.dto.data.ShopDTO
import io.madeformaid.affiliation.domain.shop.mapper.ShopMapper
import io.madeformaid.affiliation.domain.shop.repository.ShopRepository
import io.madeformaid.shared.dto.ValueLabelDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ShopQueryService(
    private val shopRepository: ShopRepository,
) {
    fun autoCompleteSearch(keyword: String): List<ValueLabelDTO> {
        return shopRepository.findByNameLike("%$keyword%").map { ValueLabelDTO(it.id, it.name) }
    }

    fun getShopDetail(shopId: String): ShopDTO {
        return ShopMapper.toDTO(
            shopRepository.findById(shopId)
                .orElseThrow { IllegalArgumentException("Shop with ID $shopId not found") }
        )
    }
}
