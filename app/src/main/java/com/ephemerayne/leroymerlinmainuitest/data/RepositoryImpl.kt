package com.ephemerayne.leroymerlinmainuitest.data

import androidx.lifecycle.LiveData
import com.ephemerayne.leroymerlinmainuitest.data.local.Dao
import com.ephemerayne.leroymerlinmainuitest.data.local.FakeDao
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Category
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository

class RepositoryImpl : Repository {

    private val dao: Dao = FakeDao()

    override fun insertProductCategory(category: ProductCategory) =
        dao.insertProductCategory(category)

    override fun getCategories(): LiveData<List<Category>> = dao.getCategories()

    override fun insertProduct(product: Product) = dao.insertProduct(product)

    override fun getProducts(): LiveData<List<Product>> = dao.getProducts()
}