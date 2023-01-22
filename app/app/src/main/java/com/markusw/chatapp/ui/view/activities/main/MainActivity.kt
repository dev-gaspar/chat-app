package com.markusw.chatapp.ui.view.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.markusw.chatapp.ui.theme.ChatAppTheme
import com.markusw.chatapp.ui.view.screens.Screens
import com.markusw.chatapp.ui.view.screens.chat.ChatScreen
import com.markusw.chatapp.ui.view.screens.main.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screens.MainScreen.route
                    ) {
                        composable(route = Screens.MainScreen.route) {
                            MainScreen(navController = navController)
                        }
                        composable(
                            route = "${Screens.ChatScreen.route}/{userName}",
                            arguments = listOf(
                                navArgument("userName") {
                                    type = NavType.StringType
                                })
                        ) {
                            val userName = it.arguments?.getString("userName")

                            ChatScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
