package com.samigehi.core.utils

import android.util.Log
import com.samigehi.core.AppCore

object Logger {

    fun e(msg: String) {
        if (AppCore.DEBUG)
            Log.e("CleanArchKoin", msg)
    }

    fun e(tag: String, msg: String) {
        if (AppCore.DEBUG)
            Log.e(tag, msg)
    }

}