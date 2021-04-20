package com.ephemerayne.leroymerlinmainuitest.data

import androidx.lifecycle.LiveData
import com.ephemerayne.leroymerlinmainuitest.data.local.AppDao
import com.ephemerayne.leroymerlinmainuitest.data.local.AppDatabase
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository

class RepositoryImpl(appDatabase: AppDatabase) : Repository {

    private val appDao: AppDao = appDatabase.appDao()

    override fun insertProductCategory(category: ProductCategory) =
        appDao.insertProductCategory(category)

    override fun getCategories(): LiveData<List<ProductCategory>> = appDao.getCategories()

    override fun insertProduct(product: Product) = appDao.insertProduct(product)

    override fun getProducts(): LiveData<List<Product>> = appDao.getProducts()
}