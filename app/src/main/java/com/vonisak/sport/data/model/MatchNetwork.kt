package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class MatchNetwork(
    @SerializedName("data") val data: MatchDataNetwork
)
