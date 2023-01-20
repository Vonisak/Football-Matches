package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class StageNetwork(
    @SerializedName("stage_id") val id: Int,
    @SerializedName("name") val name: String
)