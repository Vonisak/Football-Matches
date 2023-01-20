package com.vonisak.sport.data.repository

import com.vonisak.sport.data.converter.*
import com.vonisak.sport.data.datasorce.SportDataSource
import com.vonisak.sport.domain.entity.*
import com.vonisak.sport.domain.repository.SportRepository
import javax.inject.Inject

class SportRepositoryImpl @Inject constructor(private val dataSource: SportDataSource) :
    SportRepository {

    override suspend fun getLeagueById(leagueId: Int): League =
        dataSource.getLeagueById(leagueId).toLeague()

    override suspend fun getSeasons(leagueId: Int): List<SeasonData> =
        dataSource.getSeasons(leagueId).toSeason().data

    override suspend fun getMatches(seasonId: Int): List<MatchData> =
        dataSource.getMatches(seasonId).data.map { matchDataNetwork ->
            matchDataNetwork.toMatchData()
        }

    override suspend fun getMatchById(matchId: Int): MatchData =
        dataSource.getMatchById(matchId).data.toMatchData()

    override suspend fun getSeasonById(seasonId: Int): SeasonData =
        dataSource.getSeasonById(seasonId).data.toSeasonData()
}