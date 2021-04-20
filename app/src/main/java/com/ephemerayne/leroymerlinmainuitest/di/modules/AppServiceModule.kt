package com.ephemerayne.leroymerlinmainuitest.di.modules

import com.ephemerayne.leroymerlinmainuitest.data.remote.AppApi
import com.ephemerayne.leroymerlinmainuitest.data.remote.FakeAppService
import dagger.Module
import dagger.Provides

@Module
class AppServiceModule {

    @Provides
    fun provideService(): AppApi = FakeAppService()
}