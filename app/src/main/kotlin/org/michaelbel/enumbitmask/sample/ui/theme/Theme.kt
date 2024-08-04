@file:Suppress("UnusedReceiverParameter")

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
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme(),
        content = content
    )
}