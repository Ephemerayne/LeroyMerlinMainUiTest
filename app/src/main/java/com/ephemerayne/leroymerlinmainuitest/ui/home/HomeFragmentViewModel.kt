package com.ephemerayne.leroymerlinmainuitest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ephemerayne.leroymerlinmainuitest.domain.entity.CategoryEntity
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository
import javax.inject.Inject


class HomeFragmentViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getCategories(): LiveData<List<CategoryEntity>> = repository.getCategories()

    fun getProducts(): LiveData<List<ProductEntity>> = repository.getProducts()
}