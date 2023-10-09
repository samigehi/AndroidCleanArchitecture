package com.samigehi.koin.app.contacts.compose.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.samigehi.koin.app.components.TextInput
import com.samigehi.koin.app.contacts.viewmodel.CreateContactViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@Composable
fun CreateContactView(
    navController: NavController,
    vm: CreateContactViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("New Contact")
                }, actions = {
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background),
                        onClick = {
                            runBlocking {
                                withContext(Dispatchers.IO) {
                                    vm.createContact()
                                }
                                navController.popBackStack()
                            }

                        }) {
                        Text("Save")
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


