package com.example.fishingshopcompose.ui.common

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import com.example.fishingshopcompose.ui.AppScreen

object Navigator {

    private var _currentScreen = mutableStateOf(
        AppScreen.LoginScreen
    )
    val currentScreen: State<AppScreen> = _currentScreen

    private var previousScreen: MutableState<AppScreen> = mutableStateOf(
        AppScreen.LoginScreen
    )

    fun navigateTo(destination: AppScreen, navController: NavController) {
        previousScreen.value = _currentScreen.value
        _currentScreen.value = destination
        navController.navigate(destination.name)
    }

    fun navigateBack(navController: NavController) {
        _currentScreen.value = previousScreen.value
        navController.popBackStack()
    }
}