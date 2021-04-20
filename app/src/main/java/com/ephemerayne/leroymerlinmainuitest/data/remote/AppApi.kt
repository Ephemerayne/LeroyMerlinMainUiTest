package com.ephemerayne.leroymerlinmainuitest.data.remote

import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory
import io.reactivex.rxjava3.core.Observable

interface AppApi {

    fun getCategories(): Observable<List<ProductCategory>>

    fun getProducts(): Observable<List<Product>>
}