package com.ephemerayne.leroymerlinmainuitest.data.remote

import com.ephemerayne.leroymerlinmainuitest.domain.entity.CategoryEntity
import com.ephemerayne.leroymerlinmainuitest.domain.entity.ProductEntity
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class FakeAppService : AppApi {

    override fun getCategories(): Observable<List<CategoryEntity>> {
        return Observable.fromArray(
            listOf(
                CategoryEntity(1, "Сад", "https://freepngimg.com/thumb/flower/60077-blue-installation-package-tulips-vase-application-computer-thumb.png"),
                CategoryEntity(2, "Освещение", "https://freepngimg.com/thumb/lamp/42930-6-ceramic-lamp-image-free-hq-image-thumb.png"),
                CategoryEntity(3, "Инструменты", "https://lh3.googleusercontent.com/proxy/ZyyNrIUPyEcEqaC0S7DQPLuG7YUoQHJo7thoh9GYym6vOu41dirFR4jTbgI-Qi79U4Ka7l_rNpXgjDd2WFUXh6v2bRjIHsLQBeCXrERC_N3bgGkszN20wH-mYDYFCh0"),
                CategoryEntity(4, "Стройматериалы", "https://images.ru.prom.st/483410432_w306_h280_lakokrasochnye-materialy.jpg"),
                CategoryEntity(5, "Декор", "https://lh3.googleusercontent.com/proxy/pdJ2IZRxmxR2rWkSM5aCLfF1lJ5WMdFuDWIpKt2xjPuwUCmWR2wpSlXqWxqEbBj3VEBYLLjnqjDOawh-qqiULSgIhnZkXbu4exfkSbwDoATxX5gcxCCM1AIWZznJTzjxjA"),
            )
        ).delaySubscription(1000, TimeUnit.MILLISECONDS)
    }

    override fun getProducts(): Observable<List<ProductEntity>> {
        return Observable.fromArray(
            listOf(

                //Категория - Предложение ограничено

                ProductEntity(
                    0,
                    "Керамогранит Euroceramika Карвалио 15х60 см 1.35 м² цвет серый",
                    730.35,
                    "https://res.cloudinary.com/lmru/image/upload/f_auto,q_90,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/82983896_01.jpg",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductEntity(
                    1,
                    "Штукатурка гипсовая Knauf Ротбанд 30 кг",
                    413.0,
                    "https://res.cloudinary.com/lmru/image/upload/f_auto,q_90,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/10073940.jpg",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductEntity(
                    2,
                    "Грунтовка глубокого проникновения Ceresit CT17 10 л",
                    722.0,
                    "https://res.cloudinary.com/lmru/image/upload/f_auto,q_90,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/12757481.jpg",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductEntity(
                    3,
                    "Перфоратор SDS-plus Makita HR2470, 780 Вт, 2.7 Дж",
                    7788.0,
                    "https://res.cloudinary.com/lmru/image/upload/f_auto,q_90,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/956269.jpg",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),
                ProductEntity(
                    4,
                    "Шпаклёвка полимерная финишная Weber Vetonit LR Plus, 22 кг",
                    673.0,
                    "https://res.cloudinary.com/lmru/image/upload/f_auto,q_90,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/12560427.jpg",
                    isLimitedOffer = true,
                    isBestPrice = false
                ),

                //Категория - Лучшая цена

                ProductEntity(
                    5,
                    "Обои флизелиновые Vagnerplast Unplugged серые UN3202 0.53 м",
                    1068.0,
                    "https://res.cloudinary.com/lmru/image/upload/f_auto,q_90,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/16639378.jpg",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductEntity(
                    6,
                    "Кашпо Idea Дюна Ø34 h63 см v42 л пластик белый",
                    673.0,
                    "https://res.cloudinary.com/lmru/image/upload/f_auto,q_90,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/81976645.jpg",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductEntity(
                    7,
                    "Средство для мытья стёкол Prosept 0.5 л",
                    116.0,
                    "https://res.cloudinary.com/lmru/image/upload/f_auto,q_90,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/17564540.jpg",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductEntity(
                    8,
                    "Средство для акриловых ванн 0.5 л",
                    118.0,
                    "https://res.cloudinary.com/lmru/image/upload/f_auto,q_90,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/17602665.jpg",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
                ProductEntity(
                    9,
                    "Салфетка, 35х35, микрофибра, 4 шт.",
                    122.0,
                    "https://res.cloudinary.com/lmru/image/upload/f_auto,q_90,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/82019008.jpg",
                    isLimitedOffer = false,
                    isBestPrice = true
                ),
            )
        ).delaySubscription(2000, TimeUnit.MILLISECONDS)
    }
}