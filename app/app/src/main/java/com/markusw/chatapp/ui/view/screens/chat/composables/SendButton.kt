package com.markusw.chatapp.ui.view.screens.chat.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SendButton(
    onSendClicked: () -> Unit
) {
    IconButton(onClick = onSendClicked) {
        Icon(imageVector = Icons.Default.Send, contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun SendButtonPreview() {
    SendButton {

    }
}