package com.vonisak.sport.domain.usecase

import com.vonisak.sport.domain.entity.MatchData
import com.vonisak.sport.domain.repository.SportRepository
import javax.inject.Inject

class GetMatchByIdUseCase @Inject constructor(private val repository: SportRepository) {

    suspend operator fun invoke(matchId: Int): MatchData = repository.getMatchById(matchId)
}