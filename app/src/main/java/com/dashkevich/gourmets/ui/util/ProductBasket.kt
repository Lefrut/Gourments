package com.dashkevich.gourmets.ui.util

object ProductBasket {

    private val products: MutableMap<Int, Int> = mutableMapOf()

    fun getProducts() = products

    fun reduceProduct(id: Int): Boolean {
        val product = products[id] ?: return false
        products[id] = products[id]!! - 1
        if (product <= 0) products.remove(id)
        return true
    }

    fun addProduct(id: Int) {
        val product = products[id]
        if (product == null) products[id] = 1
        else {
            products[id] = products[id]!! + 1
        }
        products[id]?.plus(1) ?: products.put(id, 1)

    }

    fun isEmpty(): Boolean = products.isEmpty()

    override fun toString(): String {
        return "${products.keys}"
    }

}