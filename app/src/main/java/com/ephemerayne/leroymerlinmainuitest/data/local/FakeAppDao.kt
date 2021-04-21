package com.ephemerayne.leroymerlinmainuitest.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.leroymerlinmainuitest.data.model.CategoryModel
import com.ephemerayne.leroymerlinmainuitest.data.model.ProductModel

class FakeAppDao : AppDao {

    override fun insertProductCategory(category: CategoryModel) {
    }

    override fun getCategories(): LiveData<List<CategoryModel>> {
        return MutableLiveData<List<CategoryModel>>().apply {
            value = listOf(
                CategoryModel(1, "Сад", ""),
                CategoryModel(2, "Освещение", ""),
                CategoryModel(3, "Инструменты", ""),
                CategoryModel(4, "Стройматериалы", ""),
                CategoryModel(5, "Декор", ""),
            )
        }
    }

    override fun insertProduct(product: ProductModel) {
    }

    override fun getProducts(): LiveData<List<ProductModel>> {
        return MutableLiveData<List<ProductModel>>().apply {
            value = listOf(

                //Категория - Предложение ограничено

                ProductModel(
                    0,
                    "Керамогранит Euroceramika Карвалио 15х60 см 1.35 м² цвет серый",
                    730.35,
                    "",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductModel(
                    1,
                    "Штукатурка гипсовая Knauf Ротбанд 30 кг",
                    413.0,
                    "",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductModel(
                    2,
                    "Грунтовка глубокого проникновения Ceresit CT17 10 л",
                    722.0,
                    "",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductModel(
                    3,
                    "Перфоратор SDS-plus Makita HR2470, 780 Вт, 2.7 Дж",
                    7788.0,
                    "",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductModel(
                    4,
                    "Шпаклёвка полимерная финишная Weber Vetonit LR Plus, 22 кг",
                    673.0,
                    "",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),

                //Категория - Лучшая цена

                ProductModel(
                    5,
                    "Обои флизелиновые Vagnerplast Unplugged серые UN3202 0.53 м",
                    1068.0,
                    "",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductModel(
                    6,
                    "Кашпо Idea Дюна Ø34 h63 см v42 л пластик белый",
                    673.0,
                    "",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductModel(
                    7,
                    "Средство для мытья стёкол Prosept 0.5 л",
                    116.0,
                    "",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductModel(
                    8,
                    "Средство для акриловых ванн 0.5 л",
                    118.0,
                    "",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductModel(
                    9,
                    "Салфетка, 35х35, микрофибра, 4 шт.",
                    122.0,
                    "",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
            )
        }
    }
}