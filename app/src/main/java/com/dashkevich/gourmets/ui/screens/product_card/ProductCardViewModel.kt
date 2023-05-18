package com.dashkevich.gourmets.ui.screens.product_card

import androidx.lifecycle.viewModelScope
import com.dashkevich.gourmets.common.mvi.MVIViewModel
import com.dashkevich.gourmets.data.domain.repository.GourmetsRepository
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardEffect
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardEvent
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardState
import kotlinx.coroutines.launch

class ProductCardViewModel(
    private val gourmetsRepository: GourmetsRepository,private val id: Int
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
            ProductCardEvent.ClickedBuyButton -> {
                TODO("" +
                        "1. Добавить товар в корзину" +
                        "2. Изменить на счетчик"
                )
            }
            else -> {}
        }
    }

    private fun getProduct(id: Int) = viewModelScope.launch {
        gourmetsRepository.getProduct(id).onSuccess { product ->
            setState { copy(product = listOf(product)) }
        }.onFailure {

        }
    }
}