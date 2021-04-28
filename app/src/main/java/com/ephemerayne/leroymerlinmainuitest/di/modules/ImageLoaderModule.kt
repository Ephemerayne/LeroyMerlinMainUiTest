package com.ephemerayne.leroymerlinmainuitest.di.modules

import com.ephemerayne.leroymerlinmainuitest.utils.ImageLoader
import com.ephemerayne.leroymerlinmainuitest.utils.PicassoImageLoader
import dagger.Module
import dagger.Provides

@Module
class ImageLoaderModule {

    @Provides
    fun provideImageLoader(): ImageLoader = PicassoImageLoader()

//    @Provides
//    fun provideGlide(application: Application): ImageLoader = GlideImageLoader(application)
}