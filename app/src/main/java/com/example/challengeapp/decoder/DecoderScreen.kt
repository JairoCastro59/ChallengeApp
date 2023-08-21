package com.example.challengeapp.decoder

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.challengeapp.ui.components.buttons.DeButton
import com.example.challengeapp.ui.components.textInput.DecodeTextInputLayout
import com.example.challengeapp.ui.theme.AppDeTheme

@Composable
fun DecoderScreen(decoderViewModel: DecoderViewModel) {
    val msgDecode: String by decoderViewModel.msgDecode.observeAsState(initial = "")
    val msgPretty: String by decoderViewModel.msgPretty.observeAsState(initial = "")
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (decodeBtnContainer, inputsContainer, outputContainer) = createRefs()
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .constrainAs(inputsContainer) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ){
            DecodeTextInputLayout(msgDecode, placeholder = "Mensaje a Decodificar") {
                decoderViewModel.setmsgDecoder(it)
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(decodeBtnContainer) {
                top.linkTo(inputsContainer.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            DecodeBtn(decoderViewModel, msgDecode)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .constrainAs(outputContainer) {
                top.linkTo(decodeBtnContainer.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            DecodeTextInputLayout(msgPretty, "Resultado", isSingleLine = false, isEnabled = false) {}
        }
    }
}


@Composable
fun DecodeBtn(
    decoderViewModel: DecoderViewModel,
    msgDecode: String,
) {
    DeButton(
        onClick = {
            decoderViewModel.onDecodeMessge(msgDecode)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    {
        Text(text = "Decodificar", style = AppDeTheme.type.caption)
    }
}