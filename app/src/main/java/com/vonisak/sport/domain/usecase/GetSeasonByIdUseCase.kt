package com.vonisak.sport.domain.usecase

import com.vonisak.sport.domain.entity.SeasonData
import com.vonisak.sport.domain.repository.SportRepository
import javax.inject.Inject

class GetSeasonByIdUseCase @Inject constructor(private val repository: SportRepository) {

    suspend operator fun invoke(seasonId: Int): SeasonData = repository.getSeasonById(seasonId)
}