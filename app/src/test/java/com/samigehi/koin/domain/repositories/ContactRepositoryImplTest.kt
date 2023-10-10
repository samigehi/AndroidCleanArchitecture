package com.samigehi.koin.domain.repositories

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.*
import com.samigehi.koin.data.interfaces.ContactDataSource
import com.samigehi.koin.data.source.local.LocalSource
import com.samigehi.koin.data.source.remote.RemoteSource
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel

class ContactRepositoryImplTest {
    @Test
    fun getContacts_should_return_data() = runBlocking {
        val local = mock<LocalSource>()
        val remote = mock<RemoteSource>()
        val expectedData = listOf(
            ContactResponseModel(
                id = 1,
                name = "Sumeet"
            ),
            ContactResponseModel(
                id = 2,
                name = "Kumar"
            )
        );
        whenever(local.getAllContacts()).thenReturn(expectedData)
        val repo = DataSourceImpl(local, remote)

        val result = repo.getContacts()
        verify(local, times(1)).getAllContacts()
        assertEquals(result, expectedData)
    }

    @Test
    fun getContact_should_return_data() = runBlocking {
        val local = mock<LocalSource>()
        val remote = mock<RemoteSource>()
        val expectedData = ContactResponseModel(
            id = 1,
            name = "Sumeet"
        );
        whenever(local.getOne(any())).thenReturn(expectedData)
        val repo = DataSourceImpl(local, remote)

        val result = repo.getContact(1)
        verify(local, times(1)).getOne(any())
        assertEquals(result, expectedData)
    }

    @Test
    fun deleteContact_should_return_true() = runBlocking {
        val local = mock<LocalSource>()
        val remote = mock<RemoteSource>()
        val repo = DataSourceImpl(local, remote)
        val result = repo.deleteContact(1)
        verify(local, times(1)).delete(any())
    }

    @Test
    fun updateContact_should_return_true() = runBlocking {
        val local = mock<LocalSource>()
        val remote = mock<RemoteSource>()
        val repo = DataSourceImpl(local, remote)
        val result = repo.updateContact(1, ContactRequestModel(name = "Sumeet"))
        verify(local, times(1)).update(any(), any())
    }

    @Test
    fun createContact_should_return_true() = runBlocking {
        val local = mock<LocalSource>()
        val remote = mock<RemoteSource>()
        val repo = DataSourceImpl(local, remote)
        val result = repo.createContact(ContactRequestModel(name = "Sumeet"))
        verify(local, times(1)).create(any())
    }
}