package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class TeamNetwork(
    @SerializedName("team_id")val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("short_code") val shortCode: String,
    @SerializedName("logo") val logo: String,
    @SerializedName("country") val country: CountryNetwork
)
