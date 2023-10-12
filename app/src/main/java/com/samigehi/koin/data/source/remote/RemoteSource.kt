package com.samigehi.koin.data.source.remote

import com.samigehi.koin.data.interfaces.DataSource
import com.samigehi.koin.data.source.remote.api.ApiService
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel

// not implemented
class RemoteSource(private val api: ApiService) : DataSource() {

    // here you will define remote/api source
    // this class is not implemented yet - just for demonstration purpose
    override fun getAllContacts(): List<ContactResponseModel> {
        TODO("fetch from api and return response - map to data model")
    }

    override suspend fun getOne(id: Int): ContactResponseModel? {
        TODO("fetch details of particular contact ");
    }

    override suspend fun delete(id: Int) {
        TODO("delete here")
    }

    override suspend fun update(id: Int, contact: ContactRequestModel) {
        TODO("update contact here")
    }

    override suspend fun create(data: ContactRequestModel) {
        TODO("Not yet implemented")
    }
}