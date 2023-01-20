package com.vonisak.sport.data.model

import com.google.gson.annotations.SerializedName

data class GroupNetwork(
    @SerializedName("group_id") val id: Int,
    @SerializedName("group_name") val name: String
)
