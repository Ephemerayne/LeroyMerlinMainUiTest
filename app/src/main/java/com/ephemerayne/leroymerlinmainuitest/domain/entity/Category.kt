package com.ephemerayne.leroymerlinmainuitest.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

interface Category

@Entity(tableName = "categories_table")
data class ProductCategory(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val title: String,
    val imageURL: String
) : Category

class CatalogCategory : Category

class AllCategory : Category