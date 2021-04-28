package com.ephemerayne.leroymerlinmainuitest

import android.app.Application
import com.ephemerayne.leroymerlinmainuitest.di.AppComponent
import com.ephemerayne.leroymerlinmainuitest.di.DaggerAppComponent
import com.ephemerayne.leroymerlinmainuitest.di.modules.AppModule

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initAppComponent()
    }

    private fun initAppComponent(): AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()
}