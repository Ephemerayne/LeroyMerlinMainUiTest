package com.ephemerayne.leroymerlinmainuitest.di

import com.ephemerayne.leroymerlinmainuitest.di.modules.*
import com.ephemerayne.leroymerlinmainuitest.ui.home.HomeFragment
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        AppDatabaseModule::class,
        AppDaoModule::class,
        AppServiceModule::class,
        RepositoryModule::class,
        ViewModelsModule::class
    ]
)

interface AppComponent {

    fun inject(homeFragment: HomeFragment)
}