package com.example.jetpackdemo.ui.compose.home

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.jetpackdemo.ui.compose.LoginScreen

// 一组导航，startDestination指定跳到这一组导航route时，具体跳到的页面
fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation(startDestination = "home/profile", route = "home") {
        composable("home/dashboard") { DashboardScreen(navController) }
        composable("home/settings") { SettingsScreen(navController) }
        composable("home/profile") { ProfileScreen(navController) }
    }
}

// 包含login和全部路由
@Composable
fun HomeScreen() {
    // 获得当前route
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val items = listOf(
        NavScreen.Dashboard,
        NavScreen.Profile,
        NavScreen.Settings
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            currentRoute?.let {
                Log.i("currentRoute",it)
            };
            // 满足这个条件的页面，显示底部导航栏
            if (currentRoute?.startsWith("home") == true) {
                NavigationBar {
                    items.forEach { screen ->
                        NavigationBarItem(
                            icon = { Icon(screen.icon, contentDescription = null) },
                            label = { Text(stringResource(screen.resourceId)) },
                            selected = currentRoute == screen.route,
                            onClick = {
                                navController.navigate(screen.route) {
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "login", // app进入时打开的页面
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login") { LoginScreen(navController) }
            homeGraph(navController)
        }
    }
}