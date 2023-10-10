package com.samigehi.koin.app.contacts.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.samigehi.koin.R
import com.samigehi.koin.app.base.BaseFragment
import com.samigehi.koin.app.contacts.viewmodel.ListContactsViewModel

/**
 * example to use compose with Fragment
 * @author Sumeet Kumar
 */
class ContactListFragment : BaseFragment() {

    val viewModel: ListContactsViewModel by hiltNavGraphViewModels(R.id.navigation_main)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                ContactListView(findNavController(), viewModel)
            }
        }
    }

    @Composable
    fun ContactListView(navController: NavController, vm: ListContactsViewModel) {

        LaunchedEffect(Unit) {
            doInBackground {
                vm.getContacts()
            }
        }

        Scaffold(topBar = {
            TopAppBar(title = {
                Text("Contacts")
            }, actions = {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
                    onClick = {
                        navController.navigate(R.id.action_list_fragment_to_create_fragment)
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
}
