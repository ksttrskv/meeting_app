package com.example.presentation.Theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple801,
    secondary = PurpleGrey801,
    tertiary = Pink801
)

private val LightColorScheme = lightColorScheme(
    primary = Purple401,
    secondary = PurpleGrey401,
    tertiary = Pink401

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun MyMeetingAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )

}

object MyUiTheme {
    val colors: MyColors
        @Composable
        get() = color

    val typography: MyTypography = MyTypography()
}

data class MyColors(
    val borderColor: Color,
    val brandDefault: Color,
    val secondaryColor: Color,
    val errorBgColor: Color,
    val blackColor: Color,
    val neutralActive: Color,
    val newGray: Color,
    val neutralDisabled: Color,
    val bgColor: Color,
    val brandWhite: Color,
    val offWhite: Color,
    val accentDanger: Color,
    val accentSuccess: Color,
    val neutralGrey: Color,

    )

val color = MyColors(
    brandDefault = Color(0xFF9A10F0),
    borderColor = Color(0xFF9A41FE),
    errorBgColor = Color(0xFFFFEEF4),
    secondaryColor = Color(0xFF76778E),
    blackColor = Color(0xFF000000),
    neutralActive = Color(0xFF29183B),
    newGray = Color(0xFF9797AF),
    brandWhite = Color(0xFFFFFFFF),
    neutralDisabled = Color(0xFFADB5BD),
    bgColor = Color(0xFFF5F5F5),
    accentDanger = Color(0xFFFF0000),
    accentSuccess = Color(0xFF00BF59),
    neutralGrey = Color(0xFFEFEFEF),
    offWhite = Color(0xFFF6F6FA)
)

// Градиент цветной
fun multiColorLinearGradient(): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFED3CCA),
            Color(0xFFDF34D2),
            Color(0xFFD02BD9),
            Color(0xFFBF22E1),
            Color(0xFFAE1AE8),
            Color(0xFF9A10F0),
            Color(0xFF8306F7),
            Color(0xFF6600FF),
        )
    )
}

// Градиент белый
fun multiColorLinearGradientWhite(): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFEF1FB),
            Color(0xFFFDF1FC),
            Color(0xFFFCF0FC),
            Color(0xFFFBF0FD),
            Color(0xFFF9EFFD),
            Color(0xFFF8EEFE),
            Color(0xFFF6EEFE),
            Color(0xFFF4EDFF),
        )
    )
}

// Градиент для баннера
fun multiColorComplexGradient(): Brush {
    return Brush.radialGradient(
        colors = listOf(
            Color(0xFFED3CCA),
            Color(0xFFDF34D2),
            Color(0xFFD02BD9),
            Color(0xFFBF22E1),
            Color(0xFFAE1AE8),
            Color(0xFF9A10F0),
            Color(0xFF8306F7),
            Color(0xFF6600FF),
        ),
        center = Offset(0.13f, 0.13f), // Смещение центра радиального градиента в верхний левый угол
        radius = 800f
    )
}

fun combinedGradient(): Brush {
    return Brush.linearGradient(
        colors = listOf(
            Color(0xFF8306F7),
            Color(0xFF8306F7).copy(alpha = 0f)
        ),
        end = Offset(0f, 0f),
        start = Offset(0f, Float.POSITIVE_INFINITY) // Линейный градиент от верха к низу
    )
}
