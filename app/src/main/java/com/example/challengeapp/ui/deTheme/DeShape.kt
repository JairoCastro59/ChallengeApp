package com.example.challengeapp.ui.deTheme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val DeShape = Shapes(
    large = RoundedCornerShape(20.dp),
    medium = RoundedCornerShape(16.dp),
    small = RoundedCornerShape(8.dp),
)

fun Shapes.rectangleShape(): CornerBasedShape {
    return RoundedCornerShape(size = 0.dp)
}