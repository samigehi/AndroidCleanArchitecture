package com.dubizzle.core.data.source.remote

import com.dubizzle.core.data.source.remote.network.ApiResponse
import com.dubizzle.core.data.source.remote.network.ApiService
import com.dubizzle.core.data.source.remote.response.classified.ClassifiedEntity
import com.dubizzle.core.utils.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RemoteDataSource(private val service: ApiService) {

    suspend fun getClassifieds(): Flow<ApiResponse<List<ClassifiedEntity?>>> {
        return flow {
            Logger.e("RemoteDataSource", "getClassifieds RemoteDataSource flow.....")
            try {
                val response = service.getClassifieds()
                Logger.e("RemoteDataSource", "getClassifieds RemoteDataSource response.....$response")
                val dataArray = response.results
                if (dataArray?.isNotEmpty() == true) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.catch {
            emit(ApiResponse.Error("Error"))
        }.flowOn(Dispatchers.IO)
    }
}