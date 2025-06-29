package com.umesh.todocmp.util

import androidx.compose.runtime.Composable

@Composable
actual fun HandleBackPress(onBack: () -> Unit) {
    // No-op on iOS
}