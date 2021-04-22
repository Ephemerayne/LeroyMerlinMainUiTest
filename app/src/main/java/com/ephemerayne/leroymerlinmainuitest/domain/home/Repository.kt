package com.ephemerayne.leroymerlinmainuitest.domain.home

import androidx.lifecycle.LiveData
import com.ephemerayne.leroymerlinmainuitest.domain.entity.CategoryEntity
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity

interface Repository {

    fun getCategories(): LiveData<List<CategoryEntity>>

    fun getProducts(): LiveData<List<ProductEntity>>
}