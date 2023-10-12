package com.samigehi.koin.data.source.remote.api

import com.samigehi.koin.BuildConfig
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiService {
    @GET("/contacts")
    suspend fun getContacts(): List<ContactResponseModel>

    @DELETE("/delete")
    suspend fun delete(@Query("ID") id: String): List<ContactResponseModel>

    @PUT("/update")
    suspend fun update(@Body body: ContactRequestModel): List<ContactResponseModel>

    object Factory {
        fun create(): ApiService {
            return Retrofit.Builder()
                .baseUrl("https://www.google.com")
                //.addConverterFactory(Add Gson or any other Converter Factory)
                .client(getClient())
                .build()
                .create(ApiService::class.java)
        }

        fun getClient(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

            val client = OkHttpClient.Builder()

            client.connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor)
            //.authenticator(add Authenticator)
            //.addInterceptor(add Request Interceptor())
            //.addInterceptor(add Response Interceptor())
            return client.build();
        }

    }
}