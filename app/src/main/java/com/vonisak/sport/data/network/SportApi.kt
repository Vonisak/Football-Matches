package com.vonisak.sport.data.network

import com.vonisak.sport.data.model.*
import retrofit2.http.*

interface SportApi {

    @GET("soccer/leagues/{id}")
    suspend fun getLeagueById(
       @Path("id") leagueId: Int
    ): LeagueNetwork

    @GET("soccer/seasons")
    suspend fun getSeasons(
        @Query("league_id") leagueId: Int
    ): SeasonsNetwork

    @GET("soccer/seasons/{id}")
    suspend fun getSeasonById(
        @Path("id") seasonId: Int
    ): SeasonNetwork

    @GET("soccer/matches")
    suspend fun getMatches(
        @Query("season_id") seasonId: Int
    ): MatchesNetwork

    @GET("soccer/matches/{id}")
    suspend fun getMatchById(
        @Path("id") matchId: Int
    ): MatchNetwork
}