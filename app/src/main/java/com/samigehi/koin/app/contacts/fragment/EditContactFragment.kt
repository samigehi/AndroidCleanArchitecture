package com.samigehi.koin.app.contacts.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.samigehi.koin.R
import com.samigehi.koin.app.base.BaseFragment
import com.samigehi.koin.app.components.TextInput
import com.samigehi.koin.app.contacts.viewmodel.EditContactViewModel
import com.samigehi.koin.domain.models.ContactRequestModel
import kotlinx.coroutines.runBlocking
/**
 * example to use compose with Fragment
 * @author Sumeet Kumar
 */
class EditContactFragment : BaseFragment() {

    val viewModel: EditContactViewModel by hiltNavGraphViewModels(R.id.navigation_main)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                EditContactView(findNavController(), viewModel)
            }
        }
    }


    @Composable
    fun EditContactView(
        navController: NavController,
        vm: EditContactViewModel
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

}

