package com.samigehi.koin.domain.usecases.contact

import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.interfaces.usecases.CreateContactUseCase
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.utils.Logger

class CreateContact constructor(private val contactRepository: ContactRepository) : CreateContactUseCase {
    override suspend fun create(contact: ContactRequestModel) {
        Logger.e("CreateContact: create $contact ")
        return contactRepository.createContact(contact)
    }
}