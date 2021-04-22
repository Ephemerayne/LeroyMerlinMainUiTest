package com.ephemerayne.leroymerlinmainuitest.data.local

import androidx.lifecycle.LiveData
import com.ephemerayne.leroymerlinmainuitest.data.model.CategoryModel
import com.ephemerayne.leroymerlinmainuitest.data.model.ProductModel

interface AppDao {

    fun insertProductCategory(category: CategoryModel)

    fun getCategories(): LiveData<List<CategoryModel>>

    fun insertProduct(product: ProductModel)

    fun getProducts(): LiveData<List<ProductModel>>
}