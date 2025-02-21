package com.example.bellascoffeeapp.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val bellasCoffeeScheme = BellasColorScheme(
    background = Color(250,250,250),
    onBackground = Color(250,250,250),
    primary = Color(250,250,250),
    onPrimary = Color(25,25,50),
    secondary = Color(24, 35, 63),
    bellaBlue = Color(111, 116, 123)
)

private val typography = BellasTypography(
    titleLarge = TextStyle(
        fontFamily = Helvetica,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    titleMedium = TextStyle(
        fontFamily = Helvetica,
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal
    ),
    body = TextStyle(
        fontFamily = Helvetica,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light
    ),
    labelLarge = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color(49, 56, 66)
    ),
    labelMedium = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.Normal,
        color = Color(49, 56, 66)
    ),
    labelBella = TextStyle(
        fontFamily = Helvetica,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = Color(111, 116, 123)
    )
)

@Composable
fun BellasTheme(
    content: @Composable () -> Unit
) {
    val rippleIndication = ripple()
    CompositionLocalProvider(
        LocalBellasColorScheme provides bellasCoffeeScheme,
        LocalBellasTypography provides typography,
        LocalIndication provides rippleIndication,
        content = content
    )
}

object BellasTheme{
    val colorScheme: BellasColorScheme
        @Composable get() = LocalBellasColorScheme.current

    val typography: BellasTypography
        @Composable get() = LocalBellasTypography.current
}