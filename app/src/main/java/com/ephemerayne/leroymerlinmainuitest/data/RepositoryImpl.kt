package com.ephemerayne.leroymerlinmainuitest.data

import androidx.lifecycle.LiveData
import com.ephemerayne.leroymerlinmainuitest.data.local.AppDao
import com.ephemerayne.leroymerlinmainuitest.data.local.FakeAppDao
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Category
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository

class RepositoryImpl : Repository {

    private val appDao: AppDao = FakeAppDao()

    override fun insertProductCategory(category: ProductCategory) =
        appDao.insertProductCategory(category)

    override fun getCategories(): LiveData<List<Category>> = appDao.getCategories()

    override fun insertProduct(product: Product) = appDao.insertProduct(product)

    override fun getProducts(): LiveData<List<Product>> = appDao.getProducts()
}