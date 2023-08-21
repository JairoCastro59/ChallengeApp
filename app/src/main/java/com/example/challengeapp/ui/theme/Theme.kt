package com.example.challengeapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challengeapp.ui.deTheme.BlackNeutral
import com.example.challengeapp.ui.deTheme.Blue100
import com.example.challengeapp.ui.deTheme.Blue50
import com.example.challengeapp.ui.deTheme.Blue500
import com.example.challengeapp.ui.deTheme.DeColors
import com.example.challengeapp.ui.deTheme.DeShape
import com.example.challengeapp.ui.deTheme.DeType
import com.example.challengeapp.ui.deTheme.LightNeutral
import com.example.challengeapp.ui.deTheme.Red500
import com.example.challengeapp.ui.deTheme.WhiteNeutral
import com.example.challengeapp.ui.deTheme.lexend

private val lightColorScheme = DeColors(
    primaryColor = Blue500,
    secondaryColor = Blue100,
    tertiaryColor = Blue50,
    unfocusedColor = LightNeutral,
    surfaceColor = WhiteNeutral,
    colorOnSurface = BlackNeutral,
    errorColor = Red500
)

private val typography = DeType(
    headline = TextStyle(
        fontFamily = lexend,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 47.sp
    ),
    label = TextStyle(
        fontFamily = lexend,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 47.sp
    ),
    body = TextStyle(
        fontFamily = lexend,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 47.sp
    ),
    textLink = TextStyle(
        fontFamily = lexend,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 47.sp,
        textDecoration = TextDecoration.combine(
            listOf(
                TextDecoration.Underline,
                TextDecoration.LineThrough
            )
        )
    ),
    caption = TextStyle(
        fontFamily = lexend,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 47.sp
    )
)

val shapes = Shapes(
    large = RoundedCornerShape(20.dp),
    medium = RoundedCornerShape(16.dp),
    small = RoundedCornerShape(8.dp),
)

val LocalDeColors = staticCompositionLocalOf { lightColorScheme }

val LocalDeType = staticCompositionLocalOf { typography }

val LocalDeShapes = staticCompositionLocalOf { shapes }

@Composable
fun AppDeTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalDeColors provides lightColorScheme,
        LocalDeType provides typography,
        LocalDeShapes provides shapes,
        content = content
    )
}

object AppDeTheme {
    val colors: DeColors
        @Composable
        get() = LocalDeColors.current

    val type: DeType
        @Composable
        get() = LocalDeType.current

    val shape: Shapes
        @Composable
        get() = LocalDeShapes.current
}