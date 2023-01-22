package com.markusw.chatapp.ui.view.screens.chat

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.markusw.chatapp.ui.view.screens.chat.composables.BottomBar
import com.markusw.chatapp.ui.view.screens.chat.composables.TopBar

@Composable
fun ChatScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopBar(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        },
        bottomBar = {
            BottomBar {

            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {

        }
    }
}

@Preview
@Composable
fun ChatScreenPreview() {
    ChatScreen(
        navController = rememberNavController()
    )
}