package com.ephemerayne.leroymerlinmainuitest.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ephemerayne.leroymerlinmainuitest.data.RepositoryImpl
import com.ephemerayne.leroymerlinmainuitest.data.local.AppDatabase
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository


class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val appDatabase: AppDatabase = AppDatabase.getDatabase(application)
    private val repository: Repository = RepositoryImpl(appDatabase)

    fun getCategories(): LiveData<List<ProductCategory>> = repository.getCategories()

    fun getProducts(): LiveData<List<Product>> = repository.getProducts()
}