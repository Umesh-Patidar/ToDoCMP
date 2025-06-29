package com.umesh.todocmp.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light color scheme for Material 3
val lightColors = lightColorScheme(
    primary = Color(0xFFDCDaf5),            // Button color (lavender)
    onPrimary = Color(0xFF1E1B2E),          // Button text color

    secondary = Color(0xFFCE93D8),          // Accent purple
    onSecondary = Color.White,

    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF1E1B2E),

    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF1E1B2E),

    surfaceVariant = Color(0xFFF9E6FC),      // Card color (lilac)
    onSurfaceVariant = Color(0xFF3A2F42)     // Text on card
)


// Dark color scheme for Material 3
val darkColors = darkColorScheme(
    primary = Color(0xFFB9B3E3),            // Muted lavender for button
    onPrimary = Color(0xFF1E1B2E),          // Dark text on button

    secondary = Color(0xFFE1BEE7),
    onSecondary = Color(0xFF2C003E),

    background = Color(0xFF121212),
    onBackground = Color(0xFFE0E0E0),

    surface = Color(0xFF1D1B28),
    onSurface = Color(0xFFEDE7F6),

    surfaceVariant = Color(0xFF3E2D46),      // Card dark lilac
    onSurfaceVariant = Color(0xFFF2DFF9)
)


// Composable to apply light/dark theme dynamically
@Composable
fun TodoAppTheme(
    useDarkTheme: Boolean = false, // Flag to toggle dark mode
    content: @Composable () -> Unit // UI content to wrap in theme
) {
    MaterialTheme(
        colorScheme = if (useDarkTheme) darkColors else lightColors,
        content = content
    )
}
