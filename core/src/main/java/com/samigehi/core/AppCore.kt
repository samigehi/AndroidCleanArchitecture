package com.samigehi.core

class AppCore {
    companion object {
        var DEBUG = BuildConfig.DEBUG

        fun configure(debug: Boolean) {
            AppCore.DEBUG = debug
        }
    }

}