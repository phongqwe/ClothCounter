package com.clothcounter.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CounterButton(
    text:String,
    onClick:()->Unit,
) {
    Button(onClick = { onClick() }) {
        Text(text)
    }
}
