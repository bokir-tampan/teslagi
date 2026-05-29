package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = SleekEmerald,
    secondary = SleekSlate800,
    tertiary = SleekEmeraldDark,
    background = SleekSlate900,
    surface = SleekSlate800,
    onPrimary = SleekWhite,
    onSecondary = SleekWhite,
    onBackground = SleekSlate50,
    onSurface = SleekSlate50
  )

private val LightColorScheme =
  lightColorScheme(
    primary = SleekEmerald,
    secondary = SleekSlate800,
    tertiary = SleekEmeraldDark,
    background = SleekSlate50,
    surface = SleekWhite,
    onPrimary = SleekWhite,
    onSecondary = SleekWhite,
    onBackground = SleekSlate900,
    onSurface = SleekSlate900
  )

@Composable
fun ZXPediaTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Disable dynamic color to enforce brand
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
