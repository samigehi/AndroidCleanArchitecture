package com.samigehi.core.usecases

import com.samigehi.core.data.source.ClassifiedResource
import com.samigehi.core.domain.models.Classified
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun getClassifieds(): Flow<ClassifiedResource<List<Classified>>>
}