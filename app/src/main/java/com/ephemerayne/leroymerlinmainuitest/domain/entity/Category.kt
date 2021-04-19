package com.ephemerayne.leroymerlinmainuitest.domain.entity

interface Category

data class ProductCategory(
    var id: Int? = null,
    val title: String,
    val imageURL: String
) : Category

class CatalogCategory : Category

class AllCategory : Category