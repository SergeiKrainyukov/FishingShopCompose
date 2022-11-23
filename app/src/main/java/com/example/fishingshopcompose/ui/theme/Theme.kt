package com.example.fishingshopcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Brown_transparent,
    primaryVariant = Brown_transparent,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Brown_transparent,
    primaryVariant = Brown_transparent,
    secondary = Teal200,
)

@Composable
fun FishingShopComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}