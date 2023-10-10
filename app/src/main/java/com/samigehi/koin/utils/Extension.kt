package com.samigehi.koin.utils

import android.view.View
import com.samigehi.koin.app.models.ContactListResponseModel
import com.samigehi.koin.app.models.ContactModel
import com.samigehi.koin.data.source.local.room.entities.ContactRoomEntity
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel

fun String.checkNull() = if (this.isEmpty()) "Unknown" else this

fun View.visible(visible: Boolean = true) {
    if (visible)
        this.visibility = View.VISIBLE
    else this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun ContactResponseModel.toContactListResponseModel(): ContactListResponseModel {
    return ContactListResponseModel(
        id = id.toString(),
        name = name ?: "",
    )
}

fun List<ContactResponseModel>.mapToContactsToAppModel(): List<ContactModel> {
//    val contacts = ArrayList<ContactModel>()
//    val it = listIterator()
//
//    for (i in it) {
//        if (i.id != null && !i.name.isNullOrBlank()) // check nullability
//            contacts.add(ContactModel(i.id, i.name))
//    }
    return map { ContactModel(it.id ?: -1, it.name ?: "") }
}


fun ContactRoomEntity.toContactResponseModel(): ContactResponseModel {
    return ContactResponseModel(
        id = id!!,
        name = name,
    )
}


fun ContactRequestModel.toContactRoomEntity(): ContactRoomEntity {
    return ContactRoomEntity(
        id = id,
        name = name
    )
}