package com.roblesdotdev.mvvmlogin.core.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun AppTextField(
    text: String,
    onTextChanged: (String) -> Unit,
    labelText: String?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholderText: String? = null,
    focusRequester: FocusRequester = FocusRequester()
) {
    val labelComposable: (@Composable () -> Unit)? = labelText?.let {
        @Composable {
            Text(
                text = labelText,
            )
        }
    }

    val placeholderComposable: (@Composable () -> Unit)? = placeholderText?.let {
        @Composable {
            Text(
                text = placeholderText,
            )
        }
    }
    OutlinedTextField(
        value = text,
        onValueChange = onTextChanged,
        label = labelComposable,
        placeholder = placeholderComposable,
        modifier = modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        visualTransformation = visualTransformation,
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        maxLines = 1,
    )
}