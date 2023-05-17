package com.dashkevich.gourmets.di.other

import com.dashkevich.gourmets.data.api.Endpoints
import com.dashkevich.gourmets.data.api.GourmetsService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModules = module {

    single<Retrofit> {
        Retrofit.Builder().baseUrl(Endpoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    single<GourmetsService> {
        get<Retrofit>().create(GourmetsService::class.java)
    }
}
