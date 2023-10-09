package com.samigehi.koin.data.source.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel

@Entity(tableName = "tb_contact")
data class ContactRoomEntity(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
)