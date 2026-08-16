package org.michaelbel.enumbitmask.sample.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ColorScheme.blue: Color
    @Composable get() = if (isSystemInDarkTheme()) DarkBlue else Blue

val ColorScheme.brown: Color
    @Composable get() = if (isSystemInDarkTheme()) DarkBrown else Brown

val ColorScheme.green: Color
    @Composable get() = if (isSystemInDarkTheme()) DarkGreen else Green

val ColorScheme.yellow: Color
    @Composable get() = if (isSystemInDarkTheme()) DarkYellow else Yellow

val ColorScheme.purple: Color
    @Composable get() = if (isSystemInDarkTheme()) DarkPurple else Purple

val ColorScheme.red: Color
    @Composable get() = if (isSystemInDarkTheme()) DarkRed else Red

val ColorScheme.amber: Color
    @Composable get() = if (isSystemInDarkTheme()) DarkAmber else Amber

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val darkColorScheme = darkColorScheme().copy(
        background = Color(0xFF000000),
        secondary = Color(0xFF0D0D0D),
        surfaceContainerHighest = Color(0xFF212121)
    )
    val lightColorScheme = lightColorScheme().copy(
        background = Color(0xFFF0F0F0),
        secondary = Color(0xFFF8F8F8),
        surfaceContainerHighest = Color(0xFFFFFFFF)
    )

    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme else lightColorScheme,
        content = content
    )
}
