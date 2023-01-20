package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class StatsNetwork(
    @SerializedName("home_score") val homeScore: Int,
    @SerializedName("away_score") val awayScore: Int,
    @SerializedName("ht_score") val htScore: String,
    @SerializedName("ft_score") val ftScore: String,
    @SerializedName("et_score") val etScore: String?,
    @SerializedName("ps_score") val psScore: String?
)