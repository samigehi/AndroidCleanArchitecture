package com.samigehi.koin.domain.interfaces.usecases

import com.samigehi.koin.domain.models.ContactRequestModel

interface UpdateContactUseCase {
    suspend fun update(id: Int, data: ContactRequestModel)
}