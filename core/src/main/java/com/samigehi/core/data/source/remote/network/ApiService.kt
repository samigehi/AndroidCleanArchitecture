package com.samigehi.core.data.source.remote.network

import com.samigehi.core.data.source.remote.response.classified.Classifieds
import com.samigehi.core.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET(Constant.CLASSIFIEDS)
    suspend fun getClassifieds(): Classifieds

}