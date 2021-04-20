package com.ephemerayne.leroymerlinmainuitest.di.modules

import android.app.Application
import com.ephemerayne.leroymerlinmainuitest.data.local.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class AppDatabaseModule {

    @Provides
    fun provideDatabase(application: Application): AppDatabase =
        AppDatabase.getDatabase(application)
}