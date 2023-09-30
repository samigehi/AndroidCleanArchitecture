package com.samigehi.core.usecases

import com.samigehi.core.data.source.ClassifiedResource
import com.samigehi.core.domain.internal.ClassifiedRepository
import com.samigehi.core.domain.models.Classified
import kotlinx.coroutines.flow.Flow

class UseCaseImpl(private val repo: ClassifiedRepository) : UseCase {
    override fun getClassifieds(): Flow<ClassifiedResource<List<Classified>>> {
        return repo.getClassifieds()
    }

}