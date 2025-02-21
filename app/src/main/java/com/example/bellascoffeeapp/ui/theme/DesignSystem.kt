package com.example.bellascoffeeapp.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

//colors
data class BellasColorScheme(
    val background: Color,
    val onBackground: Color,
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val bellaBlue: Color
)

//typography
data class BellasTypography(
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val body: TextStyle,
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelBella: TextStyle
)

val LocalBellasColorScheme = staticCompositionLocalOf {
    BellasColorScheme(
        background = Color.Unspecified,
        onBackground = Color.Unspecified,
        primary = Color.Unspecified,
        onPrimary = Color.Unspecified,
        secondary = Color.Unspecified,
        bellaBlue = Color.Unspecified
    )
}

val LocalBellasTypography = staticCompositionLocalOf { 
    BellasTypography(
        titleLarge = TextStyle.Default,
        titleMedium = TextStyle.Default,
        body = TextStyle.Default,
        labelLarge = TextStyle.Default,
        labelMedium = TextStyle.Default,
        labelBella = TextStyle.Default
    )
}
