package com.samigehi.koin.app.contacts.compose.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.samigehi.koin.app.components.TextInput
import com.samigehi.koin.app.contacts.viewmodel.EditContactViewModel
import com.samigehi.koin.domain.models.ContactRequestModel
import kotlinx.coroutines.runBlocking

@Composable
fun EditContactView(
    navController: NavController,
    vm: EditContactViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Edit Contact")
                }, actions = {
                    Button(onClick = {
                        runBlocking {
                            vm.updateContact(vm.id, ContactRequestModel(vm.id, "${vm.name}"))
                            navController.popBackStack()
                        }

                    }) {
                        Text("Update")
                    }
                }
            )
        }

    )
    { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextInput(vm.name, { value -> vm.onNameChange(value) }, "Name")
        }
    }
}


