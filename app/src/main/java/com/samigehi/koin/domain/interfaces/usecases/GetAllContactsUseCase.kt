package com.samigehi.koin.domain.interfaces.usecases
import com.samigehi.koin.domain.models.ContactResponseModel

interface GetAllContactsUseCase {
    suspend fun getAllContacts(): List<ContactResponseModel>
}