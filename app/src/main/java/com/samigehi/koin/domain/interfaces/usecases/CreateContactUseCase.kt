package com.samigehi.koin.domain.interfaces.usecases

import com.samigehi.koin.domain.models.ContactRequestModel

interface CreateContactUseCase {
    suspend fun create(contact: ContactRequestModel)
}