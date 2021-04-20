package com.ephemerayne.leroymerlinmainuitest.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory

@Dao
interface AppDaoRoomImpl : AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insertProductCategory(category: ProductCategory)

    @Query("SELECT * FROM categories_table")
    override fun getCategories(): LiveData<List<ProductCategory>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insertProduct(product: Product)

    @Query("SELECT * FROM products_table")
    override fun getProducts(): LiveData<List<Product>>

}