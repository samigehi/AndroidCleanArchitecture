package com.dubizzle.core

class DubizzleCore {
    companion object {
        var DEBUG = BuildConfig.DEBUG

        fun configure(debug: Boolean) {
            DubizzleCore.DEBUG = debug
        }
    }

}