package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class RoundNetwork(
    @SerializedName("round_id")val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("is_current") val isCurrent: Int
)