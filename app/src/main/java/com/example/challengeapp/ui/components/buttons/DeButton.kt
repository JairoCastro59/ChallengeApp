package com.example.challengeapp.ui.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.challengeapp.ui.theme.AppDeTheme

@Composable
fun DeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = AppDeTheme.shape.small,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AppDeTheme.colors.primaryColor,
            contentColor = AppDeTheme.colors.surfaceColor
        ),
        enabled = enabled
    ) {
        text()
    }
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    AppDeTheme {
        DeButton(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text(text = "Click me", style = AppDeTheme.type.label)
        }
    }
}