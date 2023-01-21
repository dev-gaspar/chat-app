package com.markusw.chatapp.ui.view.screens

sealed class Screens(val route: String) {
    object MainScreen: Screens("main_screen")
    object ChatScreen: Screens("chat_screen")
}
