package com.samigehi.koin.domain.repositories

import com.samigehi.koin.app.models.ContactModel
import com.samigehi.koin.data.source.local.LocalSource
import com.samigehi.koin.data.source.remote.RemoteSource
import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.mappers.DataMapper
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel
import com.samigehi.koin.utils.Logger

// right now only local/room-db source implemented
class DataSourceImpl(private val local: LocalSource, private val remote: RemoteSource) : ContactRepository {

    // not implemented
    suspend fun loadContacts(): List<ContactModel> {
        // check here and return contact based on requirements / business-logic
        // i.e. fetch from network or get from room-database and return
        val contacts = getContacts(); // this is suspend function - it will block thread
        //if(contacts.isEmpty())
        //    contacts = remote.getContacts() // if list is empty fetch from server/api
        // app layer should not have direct access to data/repo models - transform / map contacts to app models
        return DataMapper.mapContactsToAppModel(contacts) ?: listOf()
    }

    override suspend fun getContacts(): List<ContactResponseModel> {
        // check here and return contact based on requirements / business-logic
        // i.e. fetch from network or get from room-database and return
        return local.getAllContacts()
    }

    override suspend fun getContact(id: Int): ContactResponseModel? {
        // based on condition, do local/remote call
        return local.getOne(id)
    }

    override suspend fun deleteContact(id: Int) {
        // based on condition, do local/remote call
        return local.delete(id)
    }

    override suspend fun updateContact(id: Int, data: ContactRequestModel) {
        // based on condition, do local/remote call
        return local.update(id, data)
    }

    override suspend fun createContact(data: ContactRequestModel) {
        // based on condition, do local/remote call
        return local.create(data)
    }
}