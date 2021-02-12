package com.dubizzle.core.utils

import android.util.Log
import com.dubizzle.core.DubizzleCore

object Logger {

    fun e(msg: String) {
        if (DubizzleCore.DEBUG)
            Log.e("DubizzleCore", msg)
    }

    fun e(tag: String, msg: String) {
        if (DubizzleCore.DEBUG)
            Log.e(tag, msg)
    }

}