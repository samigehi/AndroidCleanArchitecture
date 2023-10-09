package com.samigehi.koin.app.contacts.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.samigehi.koin.domain.interfaces.usecases.DeleteContactUseCase
import com.samigehi.koin.domain.interfaces.usecases.UpdateContactUseCase
import com.samigehi.koin.domain.models.ContactRequestModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditContactViewModel @Inject constructor(
    private val deleteContactUseCase: DeleteContactUseCase,
    private val updateContactUseCase: UpdateContactUseCase
) : ViewModel() {

    private val _errorMessage = mutableStateOf("")
    private val _isBusy = mutableStateOf(false)
    private val _name = mutableStateOf("")
    private val _id = mutableStateOf(0)

    val name: String
        get() = _name.value

   val id: Int
        get() = _id.value

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    val errorMessage: String
        get() = _errorMessage.value

    val isBusy: Boolean
        get() = _isBusy.value

    suspend fun deleteContact(id: Int) {
        try {
            _isBusy.value = true
            deleteContactUseCase.delete(id)
        } catch (err: Exception) {
            _errorMessage.value = "an error occurred, please try again"
        } finally {
            _isBusy.value = false
        }
    }

    suspend fun updateContact(id: Int, data: ContactRequestModel) {
        try {
            _isBusy.value = true
            updateContactUseCase.update(id, data)
        } catch (err: Exception) {
            _errorMessage.value = "an error occurred, please try again"
        } finally {
            _isBusy.value = false
        }
    }
}