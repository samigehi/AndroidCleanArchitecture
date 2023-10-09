package com.samigehi.koin.app.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString

@Composable
fun TextIButton(
    value: AnnotatedString,
    onChange: (Int) -> Unit = {},
) {
    Column {
        ClickableText(
            text = value,
            onClick = onChange
        )
    }
}