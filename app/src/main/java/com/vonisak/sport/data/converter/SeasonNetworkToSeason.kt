package com.vonisak.sport.data.converter

import com.vonisak.sport.data.model.SeasonDataNetwork
import com.vonisak.sport.data.model.SeasonsNetwork
import com.vonisak.sport.domain.entity.Season
import com.vonisak.sport.domain.entity.SeasonData

fun SeasonsNetwork.toSeason(): Season = Season(this.data.map { it.toSeasonData() })

fun SeasonDataNetwork.toSeasonData(): SeasonData = SeasonData(
    this.id,
    this.name,
    this.country_id,
    this.leagueId,
    this.startDate,
    this.EndDate
)