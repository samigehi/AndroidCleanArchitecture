package com.samigehi.koin.data.source.local

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.*
import com.samigehi.koin.data.source.local.room.dao.ContactDao
import com.samigehi.koin.data.source.local.room.entities.ContactRoomEntity
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel

class LocalDataSourceTest {
    @Test
    fun getAll_should_return_data() = runBlocking {
        val mockDao = mock<ContactDao>()
        whenever(mockDao.getAll()).thenReturn(listOf(ContactRoomEntity(name = "Sumeet", id = 1)))
        val ds = LocalSource(mockDao)
        val result = ds.getAllContacts()
        assertEquals(result, listOf(ContactResponseModel(id = 1, name = "Sumeet")))
    }

    @Test
    fun getOne_should_return_data() = runBlocking {
        val mockDao = mock<ContactDao>()
        whenever(mockDao.getById(any())).thenReturn((ContactRoomEntity(name = "Sumeet", id = 1)))
        val ds = LocalSource(mockDao)
        val result = ds.getOne(1)
        verify(mockDao, times(1)).getById(1)
        assertEquals(result, ContactResponseModel(id = 1, name = "Sumeet"))
    }

    @Test
    fun delete_should_call_dao_deleteById() = runBlocking {
        val mockDao = mock<ContactDao>()
        val ds = LocalSource(mockDao)
        ds.delete(1)
        verify(mockDao, times(1)).deleteById(1)
    }

    @Test
    fun update_should_call_dao_update() = runBlocking {
        val mockDao = mock<ContactDao>()
        val ds = LocalSource(mockDao)
        ds.update(1, ContactRequestModel(name = "Sumeet"))
        verify(mockDao, times(1)).update(1, "Sumeet")
    }

    @Test
    fun create_should_call_dao_insert() = runBlocking {
        val mockDao = mock<ContactDao>()
        val ds = LocalSource(mockDao)
        ds.create(ContactRequestModel(name = "Sumeet"))
        verify(mockDao, times(1)).insert(ContactRoomEntity( name = "Sumeet"))
    }

}