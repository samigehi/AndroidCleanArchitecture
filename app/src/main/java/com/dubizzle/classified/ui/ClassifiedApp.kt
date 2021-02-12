package com.dubizzle.classified.ui

import android.app.Application
import com.dubizzle.core.di.networkModule
import com.dubizzle.core.di.repositoryModule
import com.dubizzle.classified.di.useCaseModule
import com.dubizzle.classified.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ClassifiedApp() : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@ClassifiedApp)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}