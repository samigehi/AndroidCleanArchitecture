package com.samigehi.koin.domain.repositories

import com.samigehi.koin.app.models.ContactModel
import com.samigehi.koin.data.source.local.LocalSource
import com.samigehi.koin.data.source.remote.RemoteSource
import com.samigehi.koin.domain.mappers.DataMapper
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel

// right now only local/room-db source implemented
class DataSourceImpl(private val local: LocalSource, private val remote: RemoteSource) {

//    fun getContacts(): List<ContactModel> {
//        // check here and return contact based on requirements
//        // i.e. fetch from network or get from room-database and return
//        var contacts = local.getContacts(); // this is suspend function - it will block thread
//        if(contacts.isEmpty())
//            contacts = remote.getContacts() // if list is empty fetch from server/api
//        return DataMapper.mapContactsToAppModel(contacts)
//    }

    suspend fun getContacts(): List<ContactModel> {
        // check here and return contact based on requirements
        // i.e. fetch from network or get from room-database and return
        var contacts = local.getAllContacts(); // this is suspend function - it will block thread
        //if(contacts.isEmpty())
        //    contacts = remote.getContacts() // if list is empty fetch from server/api
        return DataMapper.mapContactsToAppModel(contacts) // app layer should not have direct access to data/repo models
    }

    suspend fun getContact(id: Int): ContactResponseModel? {
        // based on condition, do local/remote call
        return local.getOne(id)
    }

    suspend fun deleteContact(id: Int) {
        // based on condition, do local/remote call
        return local.delete(id)
    }

    suspend fun updateContact(id: Int, data: ContactRequestModel) {
        // based on condition, do local/remote call
        return local.update(id, data)
    }

    suspend fun createContact(data: ContactRequestModel) {
        // based on condition, do local/remote call
        return local.create(data)
    }
}