package com.ephemerayne.leroymerlinmainuitest.di

import androidx.lifecycle.ViewModel
import com.ephemerayne.leroymerlinmainuitest.ui.home.HomeFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel::class)
    abstract fun homeFragmentViewModel(viewModel: HomeFragmentViewModel): ViewModel
}