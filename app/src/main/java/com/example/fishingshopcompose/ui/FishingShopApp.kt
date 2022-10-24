package com.example.fishingshopcompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fishingshopcompose.ui.screens.GetCodeScreen
import com.example.fishingshopcompose.ui.screens.LoginScreen

@Composable
fun FishingShopApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.LoginScreen.name,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = Screen.LoginScreen.name) {
                LoginScreen {
                    navController.navigate(Screen.GetCodeScreen.name)
                }
            }
            composable(route = Screen.GetCodeScreen.name) {
                GetCodeScreen()
            }
        }
    }
}

enum class Screen {
    LoginScreen,
    GetCodeScreen,
}