package com.markusw.chatapp.ui.view.screens.chat.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MessageField(
    modifier: Modifier = Modifier,
    label: String = "",
    textStyle: TextStyle = TextStyle(fontSize = 22.sp),
    labelStyle: TextStyle = TextStyle(fontSize = 22.sp),
    value: String = "",
    onMessageChanged: (String) -> Unit = {}
) {

    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        BasicTextField(
            value = value,
            onValueChange = onMessageChanged,
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .clip(CircleShape)
                .background(Color.LightGray)
                .padding(vertical = 14.dp, horizontal = 14.dp)
                .onFocusChanged {
                    isFocused = it.isFocused
                },
            singleLine = true,
            maxLines = 1,
            textStyle = textStyle
        )
        if(!isFocused || value.isEmpty()) {
            Text(
                text = label,
                style = labelStyle,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 14.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageFieldPreview() {
    MessageField()
}