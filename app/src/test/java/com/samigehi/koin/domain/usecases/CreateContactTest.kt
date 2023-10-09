package com.samigehi.koin.domain.usecases

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.*
import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.usecases.contact.CreateContact

class CreateContactTest {
    @Test
    fun should_return_true() = runBlocking {
        val mockContactRepo = mock<ContactRepository>()
        val useCase = CreateContact(mockContactRepo)
        val result = useCase.create(ContactRequestModel(name = "Paul"))
        verify(mockContactRepo, times(1)).createContact(any())
    }
}