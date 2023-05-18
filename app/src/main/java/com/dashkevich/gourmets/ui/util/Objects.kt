package com.dashkevich.gourmets.ui.util

import com.dashkevich.gourmets.data.model.Product

val productExample: Product = Product(
    categoryId = 1,
    description = "Вкусная еда",
    id = 1,
    image = "url/img.jpg",
    energyPer100Grams = 230.9,
    fatsPer100Grams = 2.8,
    carbohydratesPer100Grams = 3.1,
    priceOld = null,
    priceCurrent = 10,
    proteinsPer100Grams = 30.3,
    tagIds = emptyList(),
    measure = 300,
    measureUnit = "кг",
    name = "Хек"
)

const val productJsonExample = "   {\n" +
        "        \"id\": 8,\n" +
        "        \"category_id\": 676168,\n" +
        "        \"name\": \"Сезам Ролл 8шт\",\n" +
        "        \"description\": \"Урамаки ролл, украшенный кунжутом, с начинкой из тунца, обжаренного в соусе BBQ, огурца, сливочного сыра и зеленого лука  Комплектуется бесплатным набором для роллов (Соевый соус Лайт 35г., васаби 6г., имбирь 15г.). +1 набор за каждые 600 рублей в заказе\",\n" +
        "        \"image\": \"1.jpg\",\n" +
        "        \"price_current\": 39000,\n" +
        "        \"price_old\": null,\n" +
        "        \"measure\": 240,\n" +
        "        \"measure_unit\": \"г\",\n" +
        "        \"energy_per_100_grams\": 277.2,\n" +
        "        \"proteins_per_100_grams\": 9.5,\n" +
        "        \"fats_per_100_grams\": 5.9,\n" +
        "        \"carbohydrates_per_100_grams\": 46.6,\n" +
        "        \"tag_ids\": []\n" +
        "    }"