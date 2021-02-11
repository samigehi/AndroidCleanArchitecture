package com.dubizzle.core.data.source.remote.network

import com.dubizzle.core.data.source.remote.response.classified.Classifieds
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("dynamodb-writer")
    suspend fun getClassifieds(): Classifieds

}