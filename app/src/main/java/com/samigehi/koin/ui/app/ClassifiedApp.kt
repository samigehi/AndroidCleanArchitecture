package com.samigehi.koin.ui.app

import android.app.Application
import com.samigehi.core.di.networkModule
import com.samigehi.core.di.repositoryModule
import com.samigehi.koin.di.useCaseModule
import com.samigehi.koin.di.viewModelModule
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