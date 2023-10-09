package com.samigehi.koin.domain.usecases.contact

import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.interfaces.usecases.DeleteContactUseCase

class DeleteContact constructor(private val contactRepository: ContactRepository) :
    DeleteContactUseCase {
    override suspend fun delete(id: Int) {
        return contactRepository.deleteContact(id)
    }
}