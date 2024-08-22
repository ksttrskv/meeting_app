package com.example.newUiKit.newTheme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
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
    val brandColorDark: Color,
    val newBrandDefault: Color,
    val brandColorDarkMode: Color,
    val brandColorLight: Color,
    val brandColorBg: Color,

    val neutralActive: Color,
    val neutralDark: Color,
    val neutralBody: Color,
    val neutralWeak: Color,
    val neutralDisabled: Color,
    val neutralLine: Color,
    val neutralSecondaryBg: Color,
    val neutralWhite: Color,
    val neutralOffWhite: Color,

    val accentDanger: Color,
    val accentWarning: Color,
    val accentSuccess: Color,
    val accentSafe: Color,

    )

val color1 = MyColors(
    newBrandDefault = Color(0xFF9A10F0),
    brandColorDark = Color(0xFF660EC8),
    brandColorLight = Color(0xFFECDAFF),
    brandColorDarkMode = Color(0xFF8207E8),
    brandColorBg = Color(0xFFF5ECFF),
    neutralActive = Color(0xFF29183B),
    neutralDark = Color(0xFF190E26),
    neutralBody = Color(0xFF1D0835),
    neutralWeak = Color(0xFFA4A4A4),
    neutralWhite = Color(0xFFFFFFFF),
    neutralDisabled = Color(0xFFADB5BD),
    neutralLine = Color(0xFFEDEDED),
    neutralSecondaryBg = Color(0xFFF7F7FC),
    accentDanger = Color(0xFFE94242),
    accentWarning = Color(0xFFFDCF41),
    accentSuccess = Color(0xFF2CC069),
    accentSafe = Color(0xFF7BCBCF),
    neutralOffWhite = Color(0xFFF7F7FC)
)


fun multiColorGradient(): Brush {
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
