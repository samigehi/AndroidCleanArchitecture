package com.samigehi.core.di

import com.samigehi.core.data.source.ClassifiedRepositoryImpl
import com.samigehi.core.data.source.local.LocalDataSource
import com.samigehi.core.data.source.remote.RemoteDataSource
import com.samigehi.core.data.source.remote.network.ApiService
import com.samigehi.core.domain.internal.ClassifiedRepository
import com.samigehi.core.utils.Constant
import com.samigehi.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .connectTimeout(Constant.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Constant.TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource() }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ClassifiedRepository> {
        ClassifiedRepositoryImpl(
            get(),
            get(),
            get()
        )
    }
}