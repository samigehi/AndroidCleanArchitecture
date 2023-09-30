package com.samigehi.core.data.source

import com.samigehi.core.data.source.local.LocalDataSource
import com.samigehi.core.data.source.remote.RemoteDataSource
import com.samigehi.core.data.source.remote.network.ApiResponse
import com.samigehi.core.domain.internal.ClassifiedRepository
import com.samigehi.core.domain.models.Classified
import com.samigehi.core.utils.DataMapper
import com.samigehi.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class ClassifiedRepositoryImpl(
    var local: LocalDataSource,
    var remote: RemoteDataSource,
    private val executor: AppExecutors
) : ClassifiedRepository {

    override fun getClassifieds(): Flow<ClassifiedResource<List<Classified>>> {
        return flow {
            emit(ClassifiedResource.Loading())
            when (val apiResponse = remote.getClassifieds().first()) {
                is ApiResponse.Success -> {
                    val newsList = DataMapper.mapDomain(apiResponse.data)
                    emit(ClassifiedResource.Success(newsList))
                }
                is ApiResponse.Empty -> {
                    emit(ClassifiedResource.Error<List<Classified>>("Empty"))
                }
                is ApiResponse.Error -> {
                    emit(ClassifiedResource.Error<List<Classified>>(apiResponse.errorMessage))
                }
            }
        }
    }
}