package com.vonisak.sport.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vonisak.sport.domain.entity.League
import com.vonisak.sport.domain.entity.LeagueData
import com.vonisak.sport.domain.entity.MatchData
import com.vonisak.sport.domain.entity.SeasonData
import com.vonisak.sport.domain.usecase.GetLeagueUseCase
import com.vonisak.sport.domain.usecase.GetMatchByIdUseCase
import com.vonisak.sport.domain.usecase.GetSeasonByIdUseCase
import com.vonisak.sport.presentation.entity.State
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MatchDetailsViewModel @Inject constructor(
    private val getMatchByIdUseCase: GetMatchByIdUseCase,
    private val getLeagueUseCase: GetLeagueUseCase,
    private val getSeasonByIdUseCase: GetSeasonByIdUseCase
) :
    ViewModel() {

    private val _matchLiveData = MutableLiveData<State<MatchData>>()
    val matchLiveData: LiveData<State<MatchData>> = _matchLiveData

    private val _leagueLiveData = MutableLiveData<State<League>>()
    val leagueLiveData: LiveData<State<League>> = _leagueLiveData

    private val _seasonLiveData = MutableLiveData<State<SeasonData>>()
    val seasonLiveData: LiveData<State<SeasonData>> = _seasonLiveData

    private val matchExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _matchLiveData.postValue(State.Fail(throwable))
    }

    private val leagueExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _leagueLiveData.postValue(State.Fail(throwable))
    }

    private val seasonExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _seasonLiveData.postValue(State.Fail(throwable))
    }


    fun getMatch(matchId: Int) {
        CoroutineScope(Dispatchers.IO + matchExceptionHandler).launch {
            val match = getMatchByIdUseCase(matchId)
            _matchLiveData.postValue(State.Success(match))
        }
    }

    fun getLeague(leagueId: Int) {
        CoroutineScope(Dispatchers.IO + leagueExceptionHandler).launch {
            val league = getLeagueUseCase(leagueId)
            _leagueLiveData.postValue(State.Success(league))
        }
    }

    fun getSeason(seasonId: Int) {
        CoroutineScope(Dispatchers.IO + seasonExceptionHandler).launch {
            val season = getSeasonByIdUseCase(seasonId)
            _seasonLiveData.postValue(State.Success(season))
        }
    }
}