package com.example.newUiKit.newTheme

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

private val DarkColorScheme1 = darkColorScheme(
    primary = Purple801,
    secondary = PurpleGrey801,
    tertiary = Pink801
)

private val LightColorScheme1 = lightColorScheme(
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

        darkTheme -> DarkColorScheme1
        else -> LightColorScheme1
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography1,
        content = content
    )

}

object MyUiTheme {
    val colors: MyColors
        @Composable
        get() = color1

    val typography: MyTypography = MyTypography()
}

data class MyColors(
    val newBorderColor: Color,
    val newBrandDefault: Color,
    val newSecondaryColor: Color,
    val newErrorBgColor: Color,
    val newBlackColor: Color,

    val neutralActive: Color,
    val newGray: Color,
    val neutralBody: Color,
    val neutralWeak: Color,
    val newNeutralDisabled: Color,
    val neutralLine: Color,
    val newBg: Color,
    val newBrandWhite: Color,
    val newOffWhite: Color,

    val accentDanger: Color,
    val accentWarning: Color,
    val accentSuccess: Color,
    val accentSafe: Color,

    )

val color1 = MyColors(
    newBrandDefault = Color(0xFF9A10F0),
    newBorderColor = Color(0xFF9A41FE),
    newErrorBgColor = Color(0xFFFFEEF4),
    newSecondaryColor = Color(0xFF76778E),
    newBlackColor = Color(0xFF000000),
    neutralActive = Color(0xFF29183B),
    newGray = Color(0xFF9797AF),
    neutralBody = Color(0xFF1D0835),
    neutralWeak = Color(0xFFA4A4A4),
    newBrandWhite = Color(0xFFFFFFFF),
    newNeutralDisabled = Color(0xFFADB5BD),
    neutralLine = Color(0xFFEDEDED),
    newBg = Color(0xFFF5F5F5),
    accentDanger = Color(0xFFE94242),
    accentWarning = Color(0xFFFDCF41),
    accentSuccess = Color(0xFF2CC069),
    accentSafe = Color(0xFF7BCBCF),
    newOffWhite = Color(0xFFF6F6FA)
)


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
