package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class LeagueDataNetwork(
    @SerializedName("league_id") val id: Int,
    @SerializedName("country_id") val countryId: Int,
    @SerializedName("name") val name: String
)
