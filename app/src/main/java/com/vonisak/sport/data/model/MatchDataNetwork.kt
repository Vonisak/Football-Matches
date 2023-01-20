package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class MatchDataNetwork(
    @SerializedName("match_id") val id: Int,
    @SerializedName("status") val status: String,
    @SerializedName("match_start") val matchStart: String,
    @SerializedName("minute") val minute: String?,
    @SerializedName("league_id") val leagueId: Int,
    @SerializedName("season_id") val seasonId: Int,
    @SerializedName("stage") val stage: StageNetwork,
    @SerializedName("group") val group: GroupNetwork,
    @SerializedName("round") val round: RoundNetwork,
    @SerializedName("home_team") val homeTeam: TeamNetwork,
    @SerializedName("away_team") val awayTeam: TeamNetwork,
    @SerializedName("stats") val stats: StatsNetwork,
    @SerializedName("match_statistics") val matchStatistics: List<MatchStatisticNetwork>?
)
