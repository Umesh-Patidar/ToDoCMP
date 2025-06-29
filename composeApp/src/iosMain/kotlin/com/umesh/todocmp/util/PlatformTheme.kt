package com.umesh.todocmp.util

import androidx.compose.runtime.Composable
import platform.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

@Composable
actual fun getPlatformDarkTheme(): Boolean {
    return UIScreen.mainScreen
        .traitCollection
        .userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark
}
