package com.umesh.todocmp

import android.app.Application
import com.umesh.todocmp.di.appModuleWithFactory
import com.umesh.todocmp.util.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(appModuleWithFactory(DatabaseDriverFactory(this@MyApplication)))
        }
    }
}