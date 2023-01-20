package com.vonisak.sport.domain.entity

data class Team(
    val id: Int,
    val name: String,
    val shortCode: String,
    val logo: String,
    val country: Country
)
