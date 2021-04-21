package com.ephemerayne.leroymerlinmainuitest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.ephemerayne.leroymerlinmainuitest.data.local.AppDao
import com.ephemerayne.leroymerlinmainuitest.data.remote.AppApi
import com.ephemerayne.leroymerlinmainuitest.domain.entity.CategoryEntity
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val appDao: AppDao,
    private val service: AppApi
) : Repository {

    override fun getCategories(): LiveData<List<CategoryEntity>> {
        service.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(object : Observer<List<CategoryEntity>> {

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(categoryEntities: List<CategoryEntity>?) {
                    categoryEntities?.let {
                        for (category in it) {
                            appDao.insertProductCategory(category.toModel())
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    println(e)
                }

                override fun onComplete() {
                }
            })

        return appDao.getCategories().map { categoryModels ->
            categoryModels.map { it.toEntity() }
        }
    }

    override fun getProducts(): LiveData<List<ProductEntity>> {
        service.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(object : Observer<List<ProductEntity>> {

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(productEntities: List<ProductEntity>?) {
                    productEntities?.let {
                        for (product in it) {
                            appDao.insertProduct(product.toModel())
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    println(e)
                }

                override fun onComplete() {
                }
            })

        return appDao.getProducts().map { productModels ->
            productModels.map { it.toEntity() }
        }
    }
}