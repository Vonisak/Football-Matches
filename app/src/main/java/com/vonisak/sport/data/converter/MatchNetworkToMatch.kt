package com.vonisak.sport.data.converter

import com.vonisak.sport.data.model.*
import com.vonisak.sport.domain.entity.*

fun MatchesNetwork.toMatch(): Match = Match(this.data.map {
    it.toMatchData()
})

fun MatchDataNetwork.toMatchData(): MatchData = MatchData(
    this.id,
    this.status,
    this.matchStart,
    this.minute,
    this.leagueId,
    this.seasonId,
    this.stage.toStage(),
    this.group.toGroup(),
    this.round.toRound(),
    this.homeTeam.toTeam(),
    this.awayTeam.toTeam(),
    this.stats.toStats(),
    this.matchStatistics?.map { it.toMatchStatistic() }
)

fun StageNetwork.toStage(): Stage = Stage(
    this.id,
    this.name
)

fun GroupNetwork.toGroup(): Group = Group(
    this.id,
    this.name
)

fun RoundNetwork.toRound(): Round = Round(
    this.id,
    this.name,
    this.isCurrent
)

fun TeamNetwork.toTeam(): Team = Team(
    this.id,
    this.name,
    this.shortCode,
    this.logo,
    this.country.toCountry()
)

fun CountryNetwork.toCountry(): Country = Country(
    this.id,
    this.name
)

fun StatsNetwork.toStats(): Stats = Stats(
    this.homeScore,
    this.awayScore,
    this.htScore,
    this.ftScore,
    this.etScore,
    this.psScore
)

fun MatchStatisticNetwork.toMatchStatistic(): MatchStatistic = MatchStatistic(
    this.fouls,
    this.corners,
    this.offsides,
    this.shotsTotal,
    this.shotsOffTarget,
    this.shotsBlocked,
    this.penalties
)