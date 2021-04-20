package com.ephemerayne.leroymerlinmainuitest.data

import androidx.lifecycle.LiveData
import com.ephemerayne.leroymerlinmainuitest.data.local.AppDao
import com.ephemerayne.leroymerlinmainuitest.data.local.AppDatabase
import com.ephemerayne.leroymerlinmainuitest.data.remote.AppApi
import com.ephemerayne.leroymerlinmainuitest.data.remote.FakeAppService
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductCategory
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryImpl(appDatabase: AppDatabase) : Repository {

    private val appDao: AppDao = appDatabase.appDao()
    private val service: AppApi = FakeAppService()

    override fun insertProductCategory(category: ProductCategory) =
        appDao.insertProductCategory(category)

    override fun getCategories(): LiveData<List<ProductCategory>> {
        service.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(object : Observer<List<ProductCategory>> {

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(categories: List<ProductCategory>?) {
                    categories?.let {
                        for (category in it) {
                            appDao.insertProductCategory(category)
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    println(e)
                }

                override fun onComplete() {
                }
            })

        return appDao.getCategories()
    }

    override fun insertProduct(product: Product) = appDao.insertProduct(product)

    override fun getProducts(): LiveData<List<Product>> {
        service.getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe(object : Observer<List<Product>> {

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(products: List<Product>?) {
                    products?.let {
                        for (product in it) {
                            appDao.insertProduct(product)
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    println(e)
                }

                override fun onComplete() {
                }
            })

        return appDao.getProducts()
    }
}