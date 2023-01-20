package com.vonisak.sport.domain.entity

data class SeasonData(
    val id: Int,
    val name: String,
    val country_id: Int,
    val leagueId: Int,
    val startDate: String,
    val EndDate: String
)
