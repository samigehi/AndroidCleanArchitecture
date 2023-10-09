package com.samigehi.koin.app.contact.create

import com.samigehi.koin.app.contacts.viewmodel.CreateContactViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.*
import com.samigehi.koin.domain.interfaces.usecases.CreateContactUseCase
import com.samigehi.koin.domain.models.ContactRequestModel


class CreateContactViewModelTest {
    @Test
    fun createContact_should_return_true() = runBlocking {
        val mockUseCase = mock<CreateContactUseCase>()
        val vm = CreateContactViewModel(mockUseCase)
        vm.onNameChange("Paul")
        vm.createContact()
        verify(mockUseCase, times(1)).create(any())
        assertEquals(vm.errorMessage, "")
    }

    @Test
    fun should_set_error_when_createContact_fails() = runBlocking {
        val mockUseCase = mock<CreateContactUseCase>()
        whenever(mockUseCase.create(any())).thenThrow()
        val vm = CreateContactViewModel(mockUseCase)
        vm.onNameChange("Paul")
        vm.createContact()
        assertEquals(vm.errorMessage, "Error Creating Contact")
    }
}






