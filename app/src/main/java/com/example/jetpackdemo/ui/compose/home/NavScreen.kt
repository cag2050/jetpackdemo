package com.example.jetpackdemo.ui.compose.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jetpackdemo.R

// 定义底部导航
sealed class NavScreen(
    val route: String,
    val resourceId: Int,
    val icon: ImageVector
) {
    object Dashboard : NavScreen(
        "home/dashboard",
        R.string.dashboard,
        Icons.Default.Home
    )
    object Profile : NavScreen(
        "home/profile",
        R.string.profile,
        Icons.Default.Person
    )
    object Settings : NavScreen(
        "home/settings",
        R.string.settings,
        Icons.Default.Settings
    )
}