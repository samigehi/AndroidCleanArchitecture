package com.dubizzle.core.data.source.remote

import android.util.Log
import com.dubizzle.core.data.source.remote.network.ApiResponse
import com.dubizzle.core.data.source.remote.network.ApiService
import com.dubizzle.core.data.source.remote.response.classified.ClassifiedEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RemoteDataSource(private val service: ApiService) {

    suspend fun getClassifieds(): Flow<ApiResponse<List<ClassifiedEntity?>>> {
        return flow {
            try {
                val response = service.getClassifieds()
                val dataArray = response.results
                if (dataArray?.isNotEmpty() == true) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSourceMv", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}