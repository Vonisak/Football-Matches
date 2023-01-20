package com.vonisak.sport.domain.repository

import com.vonisak.sport.domain.entity.*

interface SportRepository {

    suspend fun getLeagueById(leagueId: Int): League

    suspend fun getSeasons(leagueId: Int): List<SeasonData>

    suspend fun getMatches(seasonId: Int): List<MatchData>

    suspend fun getMatchById(matchId: Int): MatchData

    suspend fun getSeasonById(seasonId: Int): SeasonData
}