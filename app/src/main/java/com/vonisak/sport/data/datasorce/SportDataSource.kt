package com.vonisak.sport.data.datasorce

import com.vonisak.sport.data.model.*
import com.vonisak.sport.data.network.SportApi
import javax.inject.Inject

class SportDataSource @Inject constructor(private val api: SportApi) {

    suspend fun getLeagueById(leagueId: Int): LeagueNetwork = api.getLeagueById(leagueId)

    suspend fun getSeasons(leagueId: Int): SeasonsNetwork = api.getSeasons(leagueId)

    suspend fun getMatches(seasonId: Int): MatchesNetwork = api.getMatches(seasonId)

    suspend fun getMatchById(matchId: Int): MatchNetwork = api.getMatchById(matchId)

    suspend fun getSeasonById(seasonId: Int): SeasonNetwork = api.getSeasonById(seasonId)
}