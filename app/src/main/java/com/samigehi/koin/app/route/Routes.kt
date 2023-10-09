package com.samigehi.koin.app.route

sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Home : Routes("home")
    object Create : Routes("create")
    object Delete : Routes("delete")
    object Update : Routes("update")
}