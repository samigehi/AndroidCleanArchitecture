package com.dubizzle.core.usecases

import com.dubizzle.core.data.source.ClassifiedResource
import com.dubizzle.core.domain.models.Classified
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun getClassifieds(): Flow<ClassifiedResource<List<Classified>>>
}