package com.ephemerayne.leroymerlinmainuitest.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ephemerayne.leroymerlinmainuitest.data.model.CategoryModel
import com.ephemerayne.leroymerlinmainuitest.data.model.ProductModel

@Dao
interface AppDaoRoomImpl : AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insertProductCategory(category: CategoryModel)

    @Query("SELECT * FROM categories_table")
    override fun getCategories(): LiveData<List<CategoryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insertProduct(product: ProductModel)

    @Query("SELECT * FROM products_table")
    override fun getProducts(): LiveData<List<ProductModel>>

}