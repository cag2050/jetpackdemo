package com.example.jetpackdemo.ui.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    Button(onClick = {
        navController.navigate("home") {
            launchSingleTop = true
            restoreState = true
            popUpTo("login") { inclusive = true }
        }
    }, modifier = Modifier.fillMaxWidth()) {
        Text("登录")
    }
}