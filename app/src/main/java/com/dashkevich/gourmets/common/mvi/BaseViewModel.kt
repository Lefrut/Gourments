package com.dashkevich.gourmets.common.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


abstract class BaseViewModel<S, I>() : IntentHandler<I>, ViewModel() {
    abstract val viewState: StateFlow<S>
}

