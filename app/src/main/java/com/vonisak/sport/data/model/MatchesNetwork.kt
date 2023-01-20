package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class MatchesNetwork(
    @SerializedName("data") val data: List<MatchDataNetwork>
)