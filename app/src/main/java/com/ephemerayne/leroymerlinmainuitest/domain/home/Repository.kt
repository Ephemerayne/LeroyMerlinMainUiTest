package com.ephemerayne.leroymerlinmainuitest.domain.home

import androidx.lifecycle.LiveData
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory

interface Repository {

    fun insertProductCategory(category: ProductCategory)

    fun getCategories(): LiveData<List<ProductCategory>>

    fun insertProduct(product: Product)

    fun getProducts(): LiveData<List<Product>>
}