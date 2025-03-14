package com.example.bellascoffeeapp

import android.app.Application
import com.example.bellascoffeeapp.utils.dependencies.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BellaApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BellaApp)
            modules(appModule)
        }
    }
}