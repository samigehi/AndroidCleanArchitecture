package com.samigehi.koin.app.contacts.compose.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.samigehi.koin.app.contacts.viewmodel.ListContactsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun ContactListView(
    navController: NavController, vm: ListContactsViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            vm.getContacts()
        }
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text("Contacts")
        }, actions = {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background),
                onClick = {
                    navController.navigate("create")
                }) {
                Text("Add")
            }
        })
    }) { padding ->
        Column(modifier = Modifier.padding(16.dp)) {
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                items(vm.contacts) { item ->
                    Row(modifier = Modifier.padding(16.dp)) {
                        Text(item.id)
                        Spacer(Modifier.width(5.dp))
                        Text(item.name)
                    }
                    Divider()
                }
            }
        }
    }
}


