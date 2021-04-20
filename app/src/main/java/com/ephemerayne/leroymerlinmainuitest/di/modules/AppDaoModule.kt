package com.ephemerayne.leroymerlinmainuitest.di.modules

import com.ephemerayne.leroymerlinmainuitest.data.local.AppDao
import com.ephemerayne.leroymerlinmainuitest.data.local.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class AppDaoModule {

    @Provides
    fun provideDao(appDatabase: AppDatabase): AppDao = appDatabase.appDao()
}