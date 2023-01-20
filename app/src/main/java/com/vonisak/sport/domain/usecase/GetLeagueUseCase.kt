package com.vonisak.sport.domain.usecase

import com.vonisak.sport.domain.entity.League
import com.vonisak.sport.domain.repository.SportRepository
import javax.inject.Inject

class GetLeagueUseCase @Inject constructor(private val repository: SportRepository) {

    suspend operator fun invoke(leagueId: Int): League = repository.getLeagueById(leagueId)
}