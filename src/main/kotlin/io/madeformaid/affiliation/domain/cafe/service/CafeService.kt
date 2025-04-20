package io.madeformaid.affiliation.domain.cafe.service

import io.madeformaid.affiliation.domain.cafe.dto.data.CafeDTO
import io.madeformaid.affiliation.domain.cafe.mapper.CafeMapper
import io.madeformaid.affiliation.domain.cafe.repository.CafeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CafeService(
        private val cafeRepository: CafeRepository,
        private val cafeMapper: CafeMapper,
) {
    fun createCafe(cafeDTO: CafeDTO) : CafeDTO {
        val cafeEntity = cafeMapper.toEntity(cafeDTO)
        val savedCafeEntity = cafeRepository.save(cafeEntity)
        return cafeMapper.toDTO(savedCafeEntity)
    }
}
