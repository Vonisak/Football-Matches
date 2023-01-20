package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class SeasonsNetwork(
    @SerializedName("data") val data: List<SeasonDataNetwork>
)