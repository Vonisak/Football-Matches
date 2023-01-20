package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class LeagueNetwork(
    @SerializedName("data") val league: LeagueDataNetwork
)