package com.dubizzle.dubizzleclassifiedtest.utils

import android.view.View

fun String.checkNull() = if (this.isEmpty()) "Unknown" else this

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}