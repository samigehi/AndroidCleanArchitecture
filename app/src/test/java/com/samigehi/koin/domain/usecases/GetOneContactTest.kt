package com.samigehi.koin.domain.usecases

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.*
import com.samigehi.koin.domain.interfaces.ContactRepository
import com.samigehi.koin.domain.models.ContactResponseModel
import com.samigehi.koin.domain.usecases.contact.GetOneContact

class GetOneContactTest {
    @Test
    fun should_return_data() = runBlocking {
        val mockContactRepo = mock<ContactRepository>()
        val expectedResponse = ContactResponseModel(id = 1, name = "Sumeet")
        whenever(mockContactRepo.getContact(any())).thenReturn(expectedResponse)
        val useCase = GetOneContact(mockContactRepo)
        val result = useCase.details(1)
        verify(mockContactRepo, times(1)).getContact(any())
        Assert.assertEquals(result, expectedResponse)
    }
}