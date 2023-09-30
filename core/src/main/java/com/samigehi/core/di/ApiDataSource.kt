package com.samigehi.core.di

import com.samigehi.core.AppCore
import com.samigehi.core.data.source.remote.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiDataSource {

    private var okhttp: OkHttpClient? = null

    private constructor() {
        okhttp = if (AppCore.DEBUG) {
            OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
        } else {
            OkHttpClient.Builder().connectTimeout(TIMEOUT, TimeUnit.SECONDS).build()
        }
    }

    fun getUrl(): String {
        return baseUrl
    }

    fun getService(): ApiService {
        return Retrofit.Builder().baseUrl(baseUrl).client(okhttp!!)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    companion object {
        val instance: ApiDataSource by lazy { ApiDataSource() }
        const val baseUrl = "https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default"
        const val TIMEOUT = 30L // in seconds
    }

}
