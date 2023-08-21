package com.example.challengeapp.decoder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.challengeapp.ui.theme.AppDeTheme

class DecoderActivity :ComponentActivity() {

    private val decoderViewModel: DecoderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDeTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = AppDeTheme.colors.surfaceColor
                ) {
                    DecoderScreen(decoderViewModel = decoderViewModel)
                }
            }
        }
    }
}
