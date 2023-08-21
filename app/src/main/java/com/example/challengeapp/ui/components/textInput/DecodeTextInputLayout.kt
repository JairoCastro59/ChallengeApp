package com.example.challengeapp.ui.components.textInput

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.challengeapp.ui.theme.AppDeTheme

@Composable
fun DecodeTextInputLayout(msg: String,
                          placeholder: String = "",
                          isSingleLine: Boolean = true,
                          isEnabled: Boolean = true,
                          onTextChanged: (String) -> Unit) {
    var isErrores by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = msg,
        onValueChange = { 
                            isErrores = validate(it)
                            onTextChanged(it)
                        },
        isError = isErrores,
        enabled = isEnabled,
        singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = AppDeTheme.colors.primaryColor,
            unfocusedBorderColor = AppDeTheme.colors.unfocusedColor,
        ),
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(text = placeholder, style= AppDeTheme.type.body)
        }
    )
    if (isErrores) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "El campo no debe estar vacio",
            color = AppDeTheme.colors.errorColor
        )
    }
}

private fun validate(inputText: String): Boolean {
    return inputText.isEmpty()
}