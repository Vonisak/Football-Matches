package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class MatchStatisticNetwork(
    @SerializedName("fouls") val fouls: Int,
    @SerializedName("corners") val corners: Int,
    @SerializedName("offsides") val offsides: Int,
    @SerializedName("shots_total") val shotsTotal: Int,
    @SerializedName("shots_off_target") val shotsOffTarget: Int,
    @SerializedName("shots_blocked") val shotsBlocked: Int,
    @SerializedName("penalties") val penalties: Int
)