package com.markusw.chatapp.ui.view.screens.chat.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.markusw.chatapp.ui.view.viewmodel.ChatViewModel

@Composable
fun BottomBar(
    viewModel: ChatViewModel = hiltViewModel(),
    onSendClicked: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {

        val message by viewModel.messageText.collectAsState()

        MessageField(
            value = message,
            onMessageChanged = viewModel::onMessageTextChanged,
            label = "Message"
        )
        Spacer(modifier = Modifier.width(5.dp))
        SendButton(onSendClicked = onSendClicked)
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar {

    }
}