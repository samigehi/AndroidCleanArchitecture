package com.dubizzle.core.data.source

import com.dubizzle.core.data.source.local.LocalDataSource
import com.dubizzle.core.data.source.remote.RemoteDataSource
import com.dubizzle.core.data.source.remote.network.ApiResponse
import com.dubizzle.core.domain.internal.ClassifiedRepository
import com.dubizzle.core.domain.models.ClassifiedAd
import com.dubizzle.core.utils.DataMapper
import com.kajangdev.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class ClassifiedRepositoryImpl(var local : LocalDataSource, var remote : RemoteDataSource, private val executor: AppExecutors) : ClassifiedRepository {
    override fun getClassifieds(): Flow<ClassifiedResource<List<ClassifiedAd>>> {
        return flow {
            emit(ClassifiedResource.Loading())
            when (val apiResponse = remote.getClassifieds().first()) {
                is ApiResponse.Success -> {
                    val newsList = DataMapper.mapDomain(apiResponse.data)
                    emit(ClassifiedResource.Success(newsList))
                }
                is ApiResponse.Empty -> {
                    emit(ClassifiedResource.Error<List<ClassifiedAd>>("Empty", null))
                }
                is ApiResponse.Error -> {
                    emit(ClassifiedResource.Error<List<ClassifiedAd>>(apiResponse.errorMessage))
                }
            }
        }
    }
}