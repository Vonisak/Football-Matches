package com.vonisak.sport.di.module

import com.vonisak.sport.data.repository.SportRepositoryImpl
import com.vonisak.sport.domain.repository.SportRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindSportRepository(impl: SportRepositoryImpl): SportRepository
}