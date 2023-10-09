package com.samigehi.koin.app.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samigehi.koin.app.base.BaseActivity
import com.samigehi.koin.app.contacts.compose.create.CreateContactView
import com.samigehi.koin.app.contacts.compose.list.ContactListView
import com.samigehi.koin.app.route.Routes
import com.samigehi.koin.app.contacts.viewmodel.CreateContactViewModel
import com.samigehi.koin.app.contacts.viewmodel.ListContactsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainComposeActivity : BaseActivity() {

    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                MainPage(navController)
            }
        }
    }

    //@Preview
    @Composable
    fun MainPage(navController: NavHostController) {
        NavHost(navController, Routes.Home.route) {
            composable(Routes.Home.route) {
                val listContactsViewModel: ListContactsViewModel = hiltViewModel()
                ContactListView(navController, listContactsViewModel)
            }
            composable(Routes.Create.route) {
                val createContactsViewModel: CreateContactViewModel = hiltViewModel()
                CreateContactView(navController, createContactsViewModel)
            }
        }
    }

    @Preview
    @Composable
    fun testPreview() {
        val navController = rememberNavController()
        MaterialTheme {
            NavHost(navController, Routes.Home.route) {
                composable(Routes.Home.route) {
                    val listContactsViewModel: ListContactsViewModel = hiltViewModel()
                    ContactListView(navController, listContactsViewModel)
                }
                composable(Routes.Create.route) {
                    val createContactsViewModel: CreateContactViewModel = hiltViewModel()
                    CreateContactView(navController, createContactsViewModel)
                }
            }
        }
    }

}
