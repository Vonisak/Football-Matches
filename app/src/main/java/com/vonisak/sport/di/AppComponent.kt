package com.vonisak.sport.di

import com.vonisak.sport.di.module.NetworkModule
import com.vonisak.sport.di.module.RepositoryModule
import com.vonisak.sport.di.module.ViewModelModule
import com.vonisak.sport.di.viewmodelFactory.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class, ViewModelModule::class])
interface AppComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}