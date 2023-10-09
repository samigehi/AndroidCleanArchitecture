package com.samigehi.koin.domain.usecases.contact

import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.interfaces.usecases.GetAllContactsUseCase
import com.samigehi.koin.domain.models.ContactResponseModel

class GetContacts constructor(private val contactRepository: ContactRepository) :
    GetAllContactsUseCase {
    override suspend fun getAllContacts(): List<ContactResponseModel> {
        return contactRepository.getContacts()
    }
}