package com.dashkevich.gourmets.ui.screens.product_card

import com.dashkevich.gourmets.common.mvi.MVIViewModel
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardEffect
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardEvent
import com.dashkevich.gourmets.ui.screens.product_card.model.ProductCardState

class ProductCardViewModel: MVIViewModel<ProductCardEvent, ProductCardState, ProductCardEffect>() {

    override fun setInitialState(): ProductCardState = ProductCardState()

    override fun handleEvents(event: ProductCardEvent) {
        when(event){
            else -> {

            }
        }
    }
}