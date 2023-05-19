package com.dashkevich.gourmets.ui.screens.product_card

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.dashkevich.gourmets.common.mvi.MVIViewModel
import com.dashkevich.gourmets.data.domain.repository.GourmetsRepository
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardEffect
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardEvent
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardState
import com.dashkevich.gourmets.ui.util.ProductBasket
import kotlinx.coroutines.launch

class ProductCardViewModel(
    private val gourmetsRepository: GourmetsRepository,
    private val id: Int
): MVIViewModel<ProductCardEvent, ProductCardState, ProductCardEffect>() {

    init {
        getProduct(id)
    }

    override fun setInitialState(): ProductCardState = ProductCardState()

    override fun handleEvents(event: ProductCardEvent) {
        when(event){
            ProductCardEvent.ClickedArrowBack -> {
                 setEffect { ProductCardEffect.NavigateBack }
            }
            is ProductCardEvent.ClickedBuyButton -> {
                ProductBasket.addProduct(event.idProduct)
                setState { copy(productsBasket = ProductBasket.getProducts().toMap()) }
            }
            is ProductCardEvent.ClickedMinus -> {
                ProductBasket.reduceProduct(event.idProduct)
                setState { copy(productsBasket = ProductBasket.getProducts().toMap()) }
            }
        }
    }

    private fun getProduct(id: Int) = viewModelScope.launch {
        gourmetsRepository.getProduct(id).onSuccess { product ->
            setState { copy(product = listOf(product)) }
        }.onFailure {
            //Todo - Обработка ошибки
            Log.d("DebugProduct", it.message.toString())
        }
    }
}