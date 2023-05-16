package com.dashkevich.gourmets

import android.app.Application
import com.dashkevich.gourmets.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GourmetsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@GourmetsApplication)
            modules(appModules)
        }
    }
}