package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class SeasonDataNetwork(
    @SerializedName("season_id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("country_id") val country_id: Int,
    @SerializedName("league_id") val leagueId: Int,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("end_date") val EndDate: String
)
