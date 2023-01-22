package com.markusw.chatapp.ui.view.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.markusw.chatapp.ui.view.screens.Screens
import com.markusw.chatapp.ui.view.viewmodel.MainViewModel

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {

    val userName by viewModel.userName.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = userName,
            onValueChange = viewModel::onUserNameChanged,
            label = {
                Text(text = "Username")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("${Screens.ChatScreen.route}/pedro")
        }) {
            Text(text = "Start chat")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}