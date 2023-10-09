package com.samigehi.koin.domain.usecases.contact

import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.interfaces.usecases.GetAllContactsUseCase
import com.samigehi.koin.domain.interfaces.usecases.GetContactUseCase
import com.samigehi.koin.domain.interfaces.usecases.UpdateContactUseCase
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel

class UpdateContact constructor(private val contactRepository: ContactRepository) :
    UpdateContactUseCase {
    override suspend fun update(id: Int, data: ContactRequestModel) {
        return contactRepository.updateContact(id, data)
    }
}