package com.samigehi.koin.data.source.remote

import com.samigehi.koin.data.source.remote.api.ApiService
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class RemoteDataSourceTest {
    @Test
    fun getAll_should_return_data() = runBlocking {
        val api = mock<ApiService>()
        whenever(api.getContacts()).thenReturn(listOf(ContactResponseModel(name = "Sumeet", id = 1)))
        val ds = RemoteSource(api)
        val result = ds.getAllContacts()
        assertEquals(result, listOf(ContactResponseModel(id = 1, name = "Sumeet")))
    }

    @Test
    fun delete_should_call_dao_deleteById() = runBlocking {
        val api = mock<ApiService>()
        val ds = RemoteSource(api)
        ds.delete(1)
        verify(api, times(1)).delete("1")
    }

    @Test
    fun update_should_call_dao_update() = runBlocking {
        val api = mock<ApiService>()
        val ds = RemoteSource(api)
        ds.update(1, ContactRequestModel(name = "Sumeet"))
        verify(api, times(1)).update(ContactRequestModel(id = 1, name = "Sumeet"))
    }
}