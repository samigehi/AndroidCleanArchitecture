package com.samigehi.koin.data.source.local

import com.samigehi.koin.data.interfaces.DataSource
import com.samigehi.koin.data.source.local.room.dao.ContactDao
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel
import com.samigehi.koin.utils.Logger
import com.samigehi.koin.utils.toContactResponseModel
import com.samigehi.koin.utils.toContactRoomEntity

class LocalSource constructor(private val dao: ContactDao) : DataSource() {


    override fun getAllContacts(): List<ContactResponseModel> {
        return dao.getAll().toList().map { it.toContactResponseModel() };
    }

    override suspend fun getOne(id: Int): ContactResponseModel? {
        val entity = dao.getById(id)
        if (entity != null) {
            return entity.toContactResponseModel()
        }
        return null
    }

    override suspend fun delete(id: Int) {
        dao.deleteById(id)
    }

    override suspend fun update(id: Int, contact: ContactRequestModel) {
        dao.update(id, contact.name)
    }

    override suspend fun create(data: ContactRequestModel) {
        val id = dao.insert(data.toContactRoomEntity())
        Logger.e("LocalSource >> create $id")
    }
}