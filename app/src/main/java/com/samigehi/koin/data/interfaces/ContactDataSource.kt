package com.samigehi.koin.data.interfaces

import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel

interface ContactDataSource {
    fun getAllContacts(): List<ContactResponseModel>
    suspend fun getOne(id: Int): ContactResponseModel?
    suspend fun delete(id: Int)
    suspend fun update(id: Int, contact: ContactRequestModel)
    suspend fun create(data: ContactRequestModel)
}