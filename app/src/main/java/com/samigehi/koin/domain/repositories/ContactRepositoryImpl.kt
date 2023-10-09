package com.samigehi.koin.domain.repositories

import com.samigehi.koin.data.interfaces.ContactDataSource
import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel
import com.samigehi.koin.utils.Logger

// right now only local/room-db source implemented
class ContactRepositoryImpl constructor(private val contactDataSource: ContactDataSource) : ContactRepository {

    override suspend fun getContacts(): List<ContactResponseModel> {
        return contactDataSource.getAllContacts()
    }

    override suspend fun getContact(id: Int): ContactResponseModel? {
        return contactDataSource.getOne(id)
    }

    override suspend fun deleteContact(id: Int) {
        return contactDataSource.delete(id)
    }

    override suspend fun updateContact(id: Int, data: ContactRequestModel) {
        return contactDataSource.update(id, data)
    }

    override suspend fun createContact(data: ContactRequestModel) {
        Logger.e("ContactRepositoryImpl create $data ")
        return contactDataSource.create(data)
    }
}