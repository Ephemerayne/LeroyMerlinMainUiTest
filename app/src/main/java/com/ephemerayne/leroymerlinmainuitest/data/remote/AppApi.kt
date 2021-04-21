package com.ephemerayne.leroymerlinmainuitest.data.remote

import com.ephemerayne.leroymerlinmainuitest.domain.entity.CategoryEntity
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity
import io.reactivex.rxjava3.core.Observable

interface AppApi {

    fun getCategories(): Observable<List<CategoryEntity>>

    fun getProducts(): Observable<List<ProductEntity>>
}