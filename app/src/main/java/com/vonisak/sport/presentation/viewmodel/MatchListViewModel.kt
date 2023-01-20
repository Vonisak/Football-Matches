package com.vonisak.sport.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vonisak.sport.domain.entity.MatchData
import com.vonisak.sport.domain.entity.Season
import com.vonisak.sport.domain.entity.SeasonData
import com.vonisak.sport.domain.usecase.GetLeagueUseCase
import com.vonisak.sport.domain.usecase.GetMatchesUseCase
import com.vonisak.sport.domain.usecase.GetSeasonsUseCase
import com.vonisak.sport.presentation.entity.State
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MatchListViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase
) : ViewModel() {

    private val _matchesLiveData = MutableLiveData<State<List<MatchData>>>()
    val matchesLiveData: LiveData<State<List<MatchData>>> = _matchesLiveData

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    private fun handleError(throwable: Throwable) {
        _matchesLiveData.postValue(State.Fail(throwable))
    }

    fun getMatches(seasonId: Int) {
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val matches = getMatchesUseCase(seasonId)
            _matchesLiveData.postValue(State.Success(matches))
            Log.i("TAG", matches.toString())
        }
    }
}