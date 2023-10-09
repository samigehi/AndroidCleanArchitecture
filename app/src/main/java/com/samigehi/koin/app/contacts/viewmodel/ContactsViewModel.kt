package com.samigehi.koin.app.contacts.viewmodel

import androidx.lifecycle.ViewModel
import com.samigehi.koin.app.models.ContactModel
import com.samigehi.koin.domain.repositories.DataSourceImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(private val source: DataSourceImpl) : ViewModel() {

    private val mContacts = MutableStateFlow(emptyList<ContactModel>())
    val posts: StateFlow<List<ContactModel>> = mContacts

    suspend fun getContacts() {
        mContacts.value = source.getContacts()
    }

}