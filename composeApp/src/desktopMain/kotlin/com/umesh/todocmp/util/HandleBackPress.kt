package com.umesh.todocmp.util

import androidx.compose.runtime.Composable


import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.*

@Composable
actual fun HandleBackPress(onBack: () -> Unit) {
    var escPressed by remember { mutableStateOf(false) }

    // A key handler that sets a flag on ESC
    val keyModifier = Modifier.onKeyEvent {
        if (it.type == KeyEventType.KeyUp && it.key == Key.Escape) {
            escPressed = true
            true
        } else false
    }

    LaunchedEffect(escPressed) {
        if (escPressed) {
            onBack()
            escPressed = false
        }
    }

    // To use this modifier, you'll need to expose it optionally
}