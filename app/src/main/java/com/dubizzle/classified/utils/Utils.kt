package com.dubizzle.classified.utils

import android.content.Context
import android.net.ConnectivityManager

object Utils {

    fun isConnected(context: Context): Boolean {
        return try {
            val cm =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                    ?: return false
            val ni = cm.activeNetworkInfo
            ni != null && (ni.type == ConnectivityManager.TYPE_WIFI || ni.type == ConnectivityManager.TYPE_MOBILE)
        } catch (e: Exception) {
            false
        }
    }
}