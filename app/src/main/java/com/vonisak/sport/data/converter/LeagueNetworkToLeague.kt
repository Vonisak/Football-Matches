package com.vonisak.sport.data.converter

import com.vonisak.sport.data.model.LeagueDataNetwork
import com.vonisak.sport.data.model.LeagueNetwork
import com.vonisak.sport.domain.entity.League
import com.vonisak.sport.domain.entity.LeagueData

fun LeagueNetwork.toLeague(): League = League(this.league.toLeagueData())

fun LeagueDataNetwork.toLeagueData(): LeagueData = LeagueData(
    this.id,
    this.countryId,
    this.name
)