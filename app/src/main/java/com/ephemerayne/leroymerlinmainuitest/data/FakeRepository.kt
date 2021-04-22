package com.ephemerayne.leroymerlinmainuitest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.leroymerlinmainuitest.domain.entity.CategoryEntity
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity
import com.ephemerayne.leroymerlinmainuitest.domain.home.Repository

class FakeRepository : Repository {

    override fun getCategories(): LiveData<List<CategoryEntity>> {
        return MutableLiveData<List<CategoryEntity>>().apply {
            value = listOf(
                CategoryEntity(1, "Сад", ""),
                CategoryEntity(2, "Освещение", ""),
                CategoryEntity(3, "Инструменты", ""),
                CategoryEntity(4, "Стройматериалы", ""),
                CategoryEntity(5, "Декор", ""),
            )
        }
    }

    override fun getProducts(): LiveData<List<ProductEntity>> {
        return MutableLiveData<List<ProductEntity>>().apply {
            value = listOf(

                //Категория - Предложение ограничено

                ProductEntity(
                    0,
                    "Керамогранит Euroceramika Карвалио 15х60 см 1.35 м² цвет серый",
                    730.35,
                    "",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductEntity(
                    1,
                    "Штукатурка гипсовая Knauf Ротбанд 30 кг",
                    413.0,
                    "",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductEntity(
                    2,
                    "Грунтовка глубокого проникновения Ceresit CT17 10 л",
                    722.0,
                    "",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductEntity(
                    3,
                    "Перфоратор SDS-plus Makita HR2470, 780 Вт, 2.7 Дж",
                    7788.0,
                    "",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductEntity(
                    4,
                    "Шпаклёвка полимерная финишная Weber Vetonit LR Plus, 22 кг",
                    673.0,
                    "",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),

                //Категория - Лучшая цена

                ProductEntity(
                    5,
                    "Обои флизелиновые Vagnerplast Unplugged серые UN3202 0.53 м",
                    1068.0,
                    "",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductEntity(
                    6,
                    "Кашпо Idea Дюна Ø34 h63 см v42 л пластик белый",
                    673.0,
                    "",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductEntity(
                    7,
                    "Средство для мытья стёкол Prosept 0.5 л",
                    116.0,
                    "",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductEntity(
                    8,
                    "Средство для акриловых ванн 0.5 л",
                    118.0,
                    "",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductEntity(
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