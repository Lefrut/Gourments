package com.dashkevich.gourmets.di.other

import android.content.Context
import com.dashkevich.gourmets.data.api.GourmetsService
import com.dashkevich.gourmets.data.domain.repository.GourmetsRepository
import com.dashkevich.gourmets.data.domain.repository.GourmetsRepositoryImpl
import org.koin.dsl.module

val domainModules = module {

    single<GourmetsRepository> {
        GourmetsRepositoryImpl(context = get<Context>(),get())
    }

}