package com.samigehi.koin.data.source.remote.api

import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel
import okhttp3.OkHttpClient
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface ApiService {
    @GET("/contacts")
    suspend fun getContacts(): List<ContactResponseModel>

    @DELETE("/delete")
    suspend fun delete(@Query("ID") id: String): List<ContactResponseModel>

    @PUT("/update")
    suspend fun update(@Body body: ContactRequestModel): List<ContactResponseModel>

    object Factory {
        fun create(): ApiService {
            TODO("return retrofit api service here")
        }

        fun getClient(): OkHttpClient {
            TODO("return okhttp client here")
        }

    }
}