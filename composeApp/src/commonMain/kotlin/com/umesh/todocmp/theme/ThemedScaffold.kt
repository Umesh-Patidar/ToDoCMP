package com.umesh.todocmp.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.umesh.todocmp.util.SetSystemBarsColor
import com.umesh.todocmp.util.getPlatformDarkTheme

@Composable
fun ThemedScaffold(
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    showSystemBars: Boolean = true,
    floatingActionButton: @Composable (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    val isDarkTheme = getPlatformDarkTheme()
    if (showSystemBars) {
        SetSystemBarsColor(
            color = backgroundColor,
            darkIcons = !isDarkTheme
        )
    }

    Scaffold(
        containerColor = backgroundColor,
        floatingActionButton = {
            floatingActionButton?.invoke()
        },
        content = content,
    )
}
