package io.madeformaid.affiliation.domain.cafe.service

import io.madeformaid.affiliation.domain.cafe.dto.data.CafeDTO
import io.madeformaid.affiliation.domain.cafe.mapper.CafeMapper
import io.madeformaid.affiliation.domain.cafe.repository.CafeRepository
import io.madeformaid.shared.dto.ValueLabelDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CafeService(
        private val cafeRepository: CafeRepository,
        private val cafeMapper: CafeMapper,
) {
    fun createCafe(cafeDTO: CafeDTO) : CafeDTO {
        if (cafeRepository.existsByName(cafeDTO.name)) {
            throw IllegalArgumentException("'${cafeDTO.name}'은 이미 사용 중인 이름입니다. 다른 이름을 입력해주세요.")
        }

        val cafeEntity = cafeMapper.toEntity(cafeDTO)
        cafeEntity.addAssociations()
        val savedCafeEntity = cafeRepository.save(cafeEntity)
        return cafeMapper.toDTO(savedCafeEntity)
    }

    @Transactional(readOnly = true)
    fun autoCompleteSearch(keyword: String): List<ValueLabelDTO> {
        return cafeRepository.findByNameLike("%$keyword%").map { ValueLabelDTO(it.id, it.name) }
    }
}
