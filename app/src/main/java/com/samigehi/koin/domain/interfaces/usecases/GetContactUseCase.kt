package com.samigehi.koin.domain.interfaces.usecases

import com.samigehi.koin.domain.models.ContactResponseModel

interface GetContactUseCase {
    suspend fun details(id: Int): ContactResponseModel?
}