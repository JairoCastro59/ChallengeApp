package com.example.challengeapp.ui.deTheme

import androidx.compose.ui.graphics.Color
import javax.annotation.concurrent.Immutable

val BlackNeutral = Color(color = 0xff000000)
val WhiteNeutral = Color(color = 0xffffffff)

val LightNeutral = Color(color = 0xffE0E0E0)
val ExtraLightNeutral = Color(color = 0xffF2F2F2)

val Red500 = Color(color = 0xffF1193D)
val Blue500 = Color(color = 0xff052F5F)
val Blue100 = Color(color = 0xff285B98)
val Blue50 = Color(color = 0xffEBEFF4)

@Immutable
data class DeColors(
    val primaryColor: Color,
    val secondaryColor: Color,
    val tertiaryColor: Color,
    val unfocusedColor: Color,
    val surfaceColor: Color,
    val colorOnSurface: Color,
    val errorColor: Color
)