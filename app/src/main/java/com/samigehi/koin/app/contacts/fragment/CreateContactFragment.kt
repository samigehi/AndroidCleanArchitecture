package com.samigehi.koin.app.contacts.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.samigehi.koin.R
import com.samigehi.koin.app.base.BaseFragment
import com.samigehi.koin.app.components.TextInput
import com.samigehi.koin.app.contacts.viewmodel.CreateContactViewModel

/**
 * example to use compose with Fragment
 * @author Sumeet Kumar
 */
class CreateContactFragment : BaseFragment() {

    val viewModel: CreateContactViewModel by hiltNavGraphViewModels(R.id.navigation_main)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                CreateContactView(findNavController(), viewModel)
            }
        }
    }

    @Composable
    fun CreateContactView(
        navController: NavController,
        vm: CreateContactViewModel
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
                                doInBackground {
                                    vm.createContact()
                                    doOnUI {
                                        navController.popBackStack()
                                    }
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


}


