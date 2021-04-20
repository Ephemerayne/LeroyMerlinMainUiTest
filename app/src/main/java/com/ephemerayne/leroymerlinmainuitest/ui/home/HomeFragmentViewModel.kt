package com.ephemerayne.leroymerlinmainuitest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository


class HomeFragmentViewModel(private val repository: Repository) : ViewModel() {
    fun getCategories(): LiveData<List<ProductCategory>> = repository.getCategories()

    fun getProducts(): LiveData<List<Product>> = repository.getProducts()
}