package com.ephemerayne.leroymerlinmainuitest.data.local

import androidx.lifecycle.LiveData
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Category
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory

interface AppDao {

    fun insertProductCategory(category: ProductCategory)

    fun getCategories(): LiveData<List<Category>>

    fun insertProduct(product: Product)

    fun getProducts(): LiveData<List<Product>>
}