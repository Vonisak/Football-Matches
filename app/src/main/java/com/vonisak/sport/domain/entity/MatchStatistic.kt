package com.vonisak.sport.domain.entity

data class MatchStatistic(
    val fouls: Int,
    val corners: Int,
    val offsides: Int,
    val shotsTotal: Int,
    val shotsOffTarget: Int,
    val shotsBlocked: Int,
    val penalties: Int
)