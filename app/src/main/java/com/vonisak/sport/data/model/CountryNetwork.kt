package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class CountryNetwork(
    @SerializedName("country_id") val id: Int,
    @SerializedName("name") val name: String
)
