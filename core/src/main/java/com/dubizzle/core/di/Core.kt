package com.dubizzle.core.di

import com.dubizzle.core.data.source.ClassifiedRepositoryImpl
import com.dubizzle.core.data.source.local.LocalDataSource
import com.dubizzle.core.data.source.remote.RemoteDataSource
import com.dubizzle.core.data.source.remote.network.ApiService
import com.dubizzle.core.domain.internal.ClassifiedRepository
import com.dubizzle.core.utils.Constant
import com.dubizzle.core.utils.AppExecutors
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