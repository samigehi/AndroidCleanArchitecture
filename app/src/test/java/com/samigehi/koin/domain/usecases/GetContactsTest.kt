package com.samigehi.koin.domain.usecases

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.*
import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.models.ContactResponseModel
import com.samigehi.koin.domain.usecases.contact.CreateContact
import com.samigehi.koin.domain.usecases.contact.GetContacts

class GetContactsTest {
    @Test
    fun should_return_data() = runBlocking {
        val mockContactRepo = mock<ContactRepository>()
        val expected = listOf(
            ContactResponseModel(
                id = 1,
                name = "Paul"
            )
        )
        whenever(mockContactRepo.getContacts()).thenReturn(expected)
        val useCase = GetContacts(mockContactRepo)
        val result = useCase.getAllContacts()
        verify(mockContactRepo, times(1)).getContacts()
        Assert.assertEquals(result, expected)
    }
}