package com.dashkevich.gourmets.common.mvi

interface IntentHandler<I> {
    fun processingIntent(intent: I)
}