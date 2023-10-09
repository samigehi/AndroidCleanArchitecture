package com.samigehi.koin.domain.usecases.contact

import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.interfaces.usecases.GetContactUseCase
import com.samigehi.koin.domain.models.ContactResponseModel

class GetOneContact constructor(private val contactRepository: ContactRepository) :
    GetContactUseCase {
    override suspend fun details(id: Int): ContactResponseModel? {
        return contactRepository.getContact(id)
    }
}