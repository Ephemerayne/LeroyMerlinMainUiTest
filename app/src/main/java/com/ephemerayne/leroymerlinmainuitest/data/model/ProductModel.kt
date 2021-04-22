package com.ephemerayne.leroymerlinmainuitest.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class ProductModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val title: String,
    val price: Double,
    val imageURL: String,
    var isLimitedOffer: Boolean = false,
    var isBestPrice: Boolean = false
)
