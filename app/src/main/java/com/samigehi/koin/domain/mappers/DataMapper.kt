package com.samigehi.koin.domain.mappers

import com.samigehi.koin.app.models.ContactModel
import com.samigehi.koin.domain.models.ContactResponseModel

object DataMapper {

    fun mapContactsToAppModel(list: List<ContactResponseModel>?): List<ContactModel> {
        val contacts = ArrayList<ContactModel>()

        list?.let {
            for (i in it) {
                if (i.id != null && !i.name.isNullOrBlank()) // check nullability
                    contacts.add(ContactModel(i.id, i.name))
            }
        }

        return contacts
    }
}