package com.samigehi.koin.app.contacts.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.samigehi.koin.domain.interfaces.usecases.CreateContactUseCase
import com.samigehi.koin.domain.models.ContactRequestModel
import com.samigehi.koin.utils.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateContactViewModel @Inject constructor(private val createContactUseCase: CreateContactUseCase) : ViewModel() {

    private val _errorMessage = mutableStateOf("")
    private val _name = mutableStateOf("")

    val name: String
        get() = _name.value


    val errorMessage: String
        get() = _errorMessage.value

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    suspend fun createContact() {
        Logger.e("createContact >>>> ")
        try {
            createContactUseCase.create(ContactRequestModel(null, _name.value))
            Logger.e("createContact done ")
        } catch (err: Exception) {
            err.printStackTrace()
            Logger.e("createContact error")
            _errorMessage.value = "an error occurred, please try again"
        }
    }
}