package com.samigehi.koin.app.contacts.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.samigehi.koin.utils.toContactListResponseModel
import com.samigehi.koin.app.models.ContactListResponseModel
import com.samigehi.koin.domain.interfaces.usecases.GetAllContactsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ListContactsViewModel @Inject constructor(private val getAllContactsUseCase: GetAllContactsUseCase) :
    ViewModel() {
    private val _errorMessage = mutableStateOf("")
    private val _contacts = mutableStateListOf<ContactListResponseModel>()

    val errorMessage: String
        get() = _errorMessage.value


    val contacts: List<ContactListResponseModel>
        get() = _contacts.toList()

    suspend fun getContacts() {
        try {
            _contacts.clear()
            val list = getAllContactsUseCase.getAllContacts()
            _contacts.addAll(list.map { it.toContactListResponseModel() })
        } catch (err: Exception) {
            err.printStackTrace()
            _errorMessage.value = "an error occurred!"
        }
    }
}