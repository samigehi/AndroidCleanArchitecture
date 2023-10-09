package com.samigehi.koin.app.contact.list

import com.samigehi.koin.app.models.ContactListResponseModel
import com.samigehi.koin.app.contacts.viewmodel.ListContactsViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import com.samigehi.koin.domain.interfaces.usecases.GetAllContactsUseCase
import com.samigehi.koin.domain.models.ContactResponseModel

class ListContactsViewModelTest {
    @Test
    fun should_set_contacts_with_data() = runBlocking {
        val mockUseCase = mock<GetAllContactsUseCase>()
        val expectedResult = listOf(
            ContactResponseModel(id = 1, name = "Sumeet"),
            ContactResponseModel(id = 2, name = "Kumar")
        )
        whenever(mockUseCase.getAllContacts()).thenReturn(expectedResult)
        val vm = ListContactsViewModel(mockUseCase)
        vm.getContacts()
        assertEquals(
            vm.contacts,
            listOf(
                ContactListResponseModel(id = "1", name = "Sumeet"),
                ContactListResponseModel(id = "2", name = "Kumar")
            )
        )
        assertEquals(vm.errorMessage, "")
    }

    @Test
    fun should_set_error_when_getContacts_fails() = runBlocking {
        val mockUseCase = mock<GetAllContactsUseCase>()
        whenever(mockUseCase.getAllContacts()).thenThrow()
        val vm = ListContactsViewModel(mockUseCase)
        vm.getContacts()
        assertEquals(vm.contacts.count(), 0)
        assertEquals(vm.errorMessage, "Error Fetching Contacts")

    }
}