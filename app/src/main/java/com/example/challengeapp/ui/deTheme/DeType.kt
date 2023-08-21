package com.example.challengeapp.ui.deTheme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.challengeapp.R
import javax.annotation.concurrent.Immutable


val lexend = FontFamily(
    Font(R.font.lexend, FontWeight.Normal),
    Font(R.font.lexend_bold, FontWeight.Bold)
)

@Immutable
data class DeType(
    val headline: TextStyle,
    val label: TextStyle,
    val body: TextStyle,
    val textLink: TextStyle,
    val caption: TextStyle
)