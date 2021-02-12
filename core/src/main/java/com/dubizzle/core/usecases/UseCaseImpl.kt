package com.dubizzle.core.usecases

import com.dubizzle.core.data.source.ClassifiedResource
import com.dubizzle.core.domain.internal.ClassifiedRepository
import com.dubizzle.core.domain.models.Classified
import kotlinx.coroutines.flow.Flow

class UseCaseImpl(private val repo: ClassifiedRepository) : UseCase {
    override fun getClassifieds(): Flow<ClassifiedResource<List<Classified>>> {
        return repo.getClassifieds()
    }

}