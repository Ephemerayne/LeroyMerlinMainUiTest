package com.ephemerayne.leroymerlinmainuitest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ephemerayne.leroymerlinmainuitest.data.FakeRepository
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Category
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository


class HomeFragmentViewModel() : ViewModel() {

    private val repository: Repository = FakeRepository()

    fun insertProductCategory(category: ProductCategory) =
        repository.insertProductCategory(category)

    fun getCategories(): LiveData<List<Category>> = repository.getCategories()

    fun insertProduct(product: Product) = repository.insertProduct(product)

    fun getProducts(): LiveData<List<Product>> = repository.getProducts()
}