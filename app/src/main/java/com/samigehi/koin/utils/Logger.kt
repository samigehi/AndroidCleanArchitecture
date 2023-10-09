package com.samigehi.koin.utils

import android.util.Log
import com.samigehi.koin.BuildConfig

object Logger {
    fun e(msg: String?) {
        if (BuildConfig.DEBUG)
            Log.e("TestApp", msg ?: " - ")
    }
}