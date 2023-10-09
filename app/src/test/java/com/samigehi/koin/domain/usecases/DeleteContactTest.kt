package com.samigehi.koin.domain.usecases

import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.*
import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.usecases.contact.DeleteContact

class DeleteContactTest {
    @Test
    fun should_return_true() = runBlocking {
        val mockContactRepo = mock<ContactRepository>()
        val useCase = DeleteContact(mockContactRepo)
        val result = useCase.delete(1)
        verify(mockContactRepo, times(1)).deleteContact(any())
    }
}