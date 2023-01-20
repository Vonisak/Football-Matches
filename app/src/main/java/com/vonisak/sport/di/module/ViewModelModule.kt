package com.vonisak.sport.di.module

import androidx.lifecycle.ViewModel
import com.vonisak.sport.di.viewmodelFactory.ViewModelKey
import com.vonisak.sport.presentation.viewmodel.MatchDetailsViewModel
import com.vonisak.sport.presentation.viewmodel.MatchListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MatchListViewModel::class)
    abstract fun bindSportViewModel(viewModel: MatchListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MatchDetailsViewModel::class)
    abstract fun bindMatchDetailsViewModel(viewModel: MatchDetailsViewModel): ViewModel
}