package com.ephemerayne.leroymerlinmainuitest.di

import com.ephemerayne.leroymerlinmainuitest.di.modules.AppModule
import com.ephemerayne.leroymerlinmainuitest.ui.home.HomeFragment
import dagger.Component

@Component(modules = [
    AppModule::class,

])

interface AppComponent {

    fun inject(homeFragment: HomeFragment)
}