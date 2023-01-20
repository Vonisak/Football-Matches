package com.vonisak.sport.domain.usecase

import com.vonisak.sport.domain.entity.Match
import com.vonisak.sport.domain.entity.MatchData
import com.vonisak.sport.domain.repository.SportRepository
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(private val repository: SportRepository) {

    suspend operator fun invoke(seasonId: Int): List<MatchData> = repository.getMatches(seasonId)
}