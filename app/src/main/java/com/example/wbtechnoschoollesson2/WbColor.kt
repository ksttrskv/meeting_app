package com.example.wbtechnoschoollesson2

import android.graphics.drawable.GradientDrawable
import androidx.compose.ui.graphics.Color

data class WbColor(
    val brandColorDark: Color,
    val brandColorDefault: Color,
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

    val color = WbColor(
        brandColorDefault = Color(0xFF9A41FE),
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




