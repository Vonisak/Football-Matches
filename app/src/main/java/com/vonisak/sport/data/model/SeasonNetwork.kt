package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class SeasonNetwork(
    @SerializedName("data") val data: SeasonDataNetwork
)
