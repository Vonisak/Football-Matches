package com.vonisak.sport.domain.entity

data class Stats(
    val homeScore: Int,
    val awayScore: Int,
    val htScore: String,
    val ftScore: String,
    val etScore: String?,
    val psScore: String?
)