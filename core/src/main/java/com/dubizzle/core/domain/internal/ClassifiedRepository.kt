package com.dubizzle.core.domain.internal

import com.dubizzle.core.data.source.ClassifiedResource
import com.dubizzle.core.domain.models.ClassifiedAd
import kotlinx.coroutines.flow.Flow

interface ClassifiedRepository {

    fun getClassifieds(): Flow<ClassifiedResource<List<ClassifiedAd>>>

}