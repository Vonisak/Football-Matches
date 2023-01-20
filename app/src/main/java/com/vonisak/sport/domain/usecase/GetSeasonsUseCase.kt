package com.vonisak.sport.domain.usecase

import com.vonisak.sport.domain.entity.Season
import com.vonisak.sport.domain.entity.SeasonData
import com.vonisak.sport.domain.repository.SportRepository
import javax.inject.Inject

class GetSeasonsUseCase @Inject constructor(private val repository: SportRepository) {

    suspend operator fun invoke(leagueId: Int): List<SeasonData> = repository.getSeasons(leagueId)
}