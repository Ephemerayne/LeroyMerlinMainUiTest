package com.ephemerayne.leroymerlinmainuitest.domain.home

import androidx.lifecycle.LiveData
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory

interface Repository {

    fun getCategories(): LiveData<List<ProductCategory>>

    fun getProducts(): LiveData<List<Product>>
}