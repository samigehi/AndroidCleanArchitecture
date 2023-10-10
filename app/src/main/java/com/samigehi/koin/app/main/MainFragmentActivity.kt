package com.samigehi.koin.app.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.samigehi.koin.R
import dagger.hilt.android.AndroidEntryPoint

// use fragments and compose

@AndroidEntryPoint
class MainFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // val controller = findNavController(R.id.navigation_main)
        //val navController = navHostFragment.navController
    }
}
