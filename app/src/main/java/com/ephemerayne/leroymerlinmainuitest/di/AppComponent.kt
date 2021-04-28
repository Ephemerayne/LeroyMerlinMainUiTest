package com.ephemerayne.leroymerlinmainuitest.di

import com.ephemerayne.leroymerlinmainuitest.di.modules.*
import com.ephemerayne.leroymerlinmainuitest.ui.home.HomeFragment
import com.ephemerayne.leroymerlinmainuitest.ui.home.ProductViewHolder
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        AppDatabaseModule::class,
        AppDaoModule::class,
        AppServiceModule::class,
        RepositoryModule::class,
        ViewModelsModule::class,
        ImageLoaderModule::class
    ]
)

interface AppComponent {

    fun inject(homeFragment: HomeFragment)

    fun inject(productViewHolder: ProductViewHolder)
}