package com.vonisak.sport.domain.entity

data class MatchData(
    val id: Int,
    val status: String,
    val matchStart: String,
    val minute: String?,
    val leagueId: Int,
    val seasonId: Int,
    val stage: Stage,
    val group: Group,
    val round: Round,
    val homeTeam: Team,
    val awayTeam: Team,
    val stats: Stats,
    val matchStatistics: List<MatchStatistic>?
)
