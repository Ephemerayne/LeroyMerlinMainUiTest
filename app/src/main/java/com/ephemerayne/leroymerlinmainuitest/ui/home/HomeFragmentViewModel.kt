package com.ephemerayne.leroymerlinmainuitest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Category
import com.ephemerayne.leroymerlinmainuitest.domain.entity.Product


class HomeFragmentViewModel : ViewModel() {

    val categories: LiveData<List<Category>> = MutableLiveData<List<Category>>().apply {
        value = listOf(
            Category(0, "Каталог", ""),
            Category(1, "Сад", ""),
            Category(2, "Освещение", ""),
            Category(3, "Инструменты", ""),
            Category(4, "Стройматериалы", ""),
            Category(5, "Декор", ""),
            Category(6, "Смотреть всё", "")
        )
    }

    val products: LiveData<List<Product>> = MutableLiveData<List<Product>>().apply {
        value = listOf(

            //Категория - Предложение ограничено

            Product(0, "Керамогранит Euroceramika Карвалио 15х60 см 1.35 м² цвет серый", 730.35, "", isLimitedOffer = true, isBestPrice = false),
            Product(1, "Штукатурка гипсовая Knauf Ротбанд 30 кг", 413.0, "", isLimitedOffer = true, isBestPrice = false),
            Product(2, "Грунтовка глубокого проникновения Ceresit CT17 10 л", 722.0, "", isLimitedOffer = true, isBestPrice = false),
            Product(3, "Перфоратор SDS-plus Makita HR2470, 780 Вт, 2.7 Дж", 7788.0, "", isLimitedOffer = true, isBestPrice = false),
            Product(4, "Шпаклёвка полимерная финишная Weber Vetonit LR Plus, 22 кг", 673.0, "", isLimitedOffer = true, isBestPrice = false),

            //Категория - Лучшая цена

            Product(5, "Обои флизелиновые Vagnerplast Unplugged серые UN3202 0.53 м", 1068.0, "", isLimitedOffer = false, isBestPrice = true),
            Product(6, "Кашпо Idea Дюна Ø34 h63 см v42 л пластик белый", 673.0, "", isLimitedOffer = false, isBestPrice = true),
            Product(7, "Средство для мытья стёкол Prosept 0.5 л", 116.0, "", isLimitedOffer = false, isBestPrice = true),
            Product(8, "Средство для акриловых ванн 0.5 л", 118.0, "", isLimitedOffer = false, isBestPrice = true),
            Product(9, "Салфетка, 35х35, микрофибра, 4 шт.", 122.0, "", isLimitedOffer = false, isBestPrice = true),
        )
    }
}