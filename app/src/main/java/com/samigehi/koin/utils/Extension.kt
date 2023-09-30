package com.samigehi.koin.utils

import android.view.View

fun String.checkNull() = if (this.isEmpty()) "Unknown" else this

fun View.visible(visible: Boolean = true) {
    if (visible)
        this.visibility = View.VISIBLE
    else this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}