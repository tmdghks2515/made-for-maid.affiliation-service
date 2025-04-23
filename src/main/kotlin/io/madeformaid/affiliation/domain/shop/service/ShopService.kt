package io.madeformaid.affiliation.domain.shop.service

import io.madeformaid.affiliation.domain.shop.dto.data.ShopDTO
import io.madeformaid.affiliation.domain.shop.mapper.ShopMapper
import io.madeformaid.affiliation.domain.shop.repository.ShopRepository
import io.madeformaid.shared.dto.ValueLabelDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ShopService(
    private val shopRepository: ShopRepository,
    private val shopMapper: ShopMapper,
) {
    fun createShop(shopDTO: ShopDTO) : ShopDTO {
        if (shopRepository.existsByName(shopDTO.name)) {
            throw IllegalArgumentException("'${shopDTO.name}'은 이미 사용 중인 이름입니다. 다른 이름을 입력해주세요.")
        }

        val shopEntity = shopMapper.toEntity(shopDTO)
        shopEntity.addAssociations()
        val savedShopEntity = shopRepository.save(shopEntity)
        return shopMapper.toDTO(savedShopEntity)
    }

    @Transactional(readOnly = true)
    fun autoCompleteSearch(keyword: String): List<ValueLabelDTO> {
        return shopRepository.findByNameLike("%$keyword%").map { ValueLabelDTO(it.id, it.name) }
    }
}
