package com.samigehi.core.domain.internal

import com.samigehi.core.data.source.ClassifiedResource
import com.samigehi.core.domain.models.Classified
import kotlinx.coroutines.flow.Flow

interface ClassifiedRepository {

    fun getClassifieds(): Flow<ClassifiedResource<List<Classified>>>

}