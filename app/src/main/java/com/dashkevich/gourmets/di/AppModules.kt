package com.dashkevich.gourmets.di

import com.dashkevich.gourmets.di.other.dataModules
import com.dashkevich.gourmets.di.other.domainModules
import com.dashkevich.gourmets.di.other.viewModelModules
import org.koin.core.module.Module


val appModules = listOf<Module>(
    viewModelModules, dataModules, domainModules
)