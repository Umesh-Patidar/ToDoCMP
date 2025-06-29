package com.umesh.todocmp.util

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable


@Composable
actual fun getPlatformDarkTheme(): Boolean = isSystemInDarkTheme()

