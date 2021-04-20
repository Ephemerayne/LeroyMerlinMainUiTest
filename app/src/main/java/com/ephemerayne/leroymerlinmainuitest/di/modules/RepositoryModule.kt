package com.ephemerayne.leroymerlinmainuitest.di.modules

import com.ephemerayne.leroymerlinmainuitest.data.RepositoryImpl
import com.ephemerayne.leroymerlinmainuitest.data.local.AppDao
import com.ephemerayne.leroymerlinmainuitest.data.remote.AppApi
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(appDao: AppDao, appApi: AppApi): Repository =
        RepositoryImpl(appDao, appApi)
}