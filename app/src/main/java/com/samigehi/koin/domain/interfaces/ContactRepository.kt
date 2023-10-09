package com.samigehi.koin.domain.interfaces

import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel

interface ContactRepository {
    suspend fun getContacts(): List<ContactResponseModel>
    suspend fun getContact(id: Int): ContactResponseModel?
    suspend fun deleteContact(id: Int)
    suspend fun updateContact(id: Int, data: ContactRequestModel)
    suspend fun createContact(data: ContactRequestModel)
}