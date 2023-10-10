package com.samigehi.koin.domain.mappers

import com.samigehi.koin.app.models.ContactModel
import com.samigehi.koin.domain.models.ContactResponseModel

object DataMapper {

    fun mapContactsToAppModel(contacts: List<ContactResponseModel>?): List<ContactModel>? {
        return contacts?.map { ContactModel(it.id ?: -1, it.name ?: "") }
    }
}