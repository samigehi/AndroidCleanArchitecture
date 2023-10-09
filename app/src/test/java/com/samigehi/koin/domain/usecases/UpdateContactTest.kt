package com.samigehi.koin.domain.usecases

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.*
import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.domain.usecases.contact.DeleteContact
import com.samigehi.koin.domain.usecases.contact.UpdateContact

class UpdateContactTest {
    @Test
    fun should_return_true() = runBlocking {
        val mockContactRepo = mock<ContactRepository>()
        val useCase = UpdateContact(mockContactRepo)
        val result = useCase.execute(1, ContactRequestModel(name = "Paul"))
        verify(mockContactRepo, times(1)).updateContact(any(), any())
    }
}