package com.example.fishingshopcompose.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fishingshopcompose.R
import com.example.fishingshopcompose.ui.common.Navigator
import com.example.fishingshopcompose.ui.common.widgets.AppDrawer
import com.example.fishingshopcompose.ui.common.widgets.CustomBottomBar
import com.example.fishingshopcompose.ui.common.widgets.TopAppBar
import com.example.fishingshopcompose.ui.screens.confirmationScreen.ConfirmationScreen
import com.example.fishingshopcompose.ui.screens.getCodeScreen.GetCodeScreen
import com.example.fishingshopcompose.ui.screens.loginScreen.LoginScreen
import com.example.fishingshopcompose.ui.screens.mainScreen.MainScreen
import com.example.fishingshopcompose.ui.theme.ClearRippleTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun FishingShopApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Crossfade(targetState = Navigator.currentScreen) { currentScreen ->
        Box {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.bg_main_screen),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Scaffold(
                topBar = {
                    if (needToShowTopBar(currentScreen.value))
                        TopAppBar(
                        scaffoldState,
                        coroutineScope
                    )
                },
                drawerContent = {
                    AppDrawer(
                        closeDrawerAction = { coroutineScope.launch { scaffoldState.drawerState.close() } }
                    )
                },
                scaffoldState = scaffoldState,
                bottomBar = {
                    if (needToShowBottomBar(currentScreen.value))
                        Box(modifier = Modifier.fillMaxWidth()) {
                            CompositionLocalProvider(LocalRippleTheme provides ClearRippleTheme) {
                                CustomBottomBar()
                            }
                        }
                },
                backgroundColor = Color.Transparent,
            ) { innerPadding ->
                BackHandler {
                    Navigator.navigateBack(navController)
                }
                NavHost(
                    navController = navController,
                    startDestination = AppScreen.LoginScreen.name,
                    modifier = modifier.padding(innerPadding)
                ) {
                    composable(route = AppScreen.LoginScreen.name) {
                        LoginScreen {
                            Navigator.navigateTo(AppScreen.GetCodeScreen, navController)
                        }
                    }
                    composable(route = AppScreen.GetCodeScreen.name) {
                        GetCodeScreen(viewModel = viewModel(), onGetCodeButtonClicked = {
                            Navigator.navigateTo(AppScreen.ConfirmationScreen, navController)
                        })
                    }
                    composable(route = AppScreen.ConfirmationScreen.name) {
                        ConfirmationScreen(viewModel()) {
                            Navigator.navigateTo(AppScreen.MainScreen, navController)
                        }
                    }
                    composable(route = AppScreen.MainScreen.name) {
                        MainScreen(viewModel())
                    }
                }
            }

        }
    }
}

private fun needToShowBottomBar(currentScreen: AppScreen): Boolean {
    return !(currentScreen == AppScreen.LoginScreen ||
            currentScreen == AppScreen.GetCodeScreen ||
            currentScreen == AppScreen.ConfirmationScreen)
}

private fun needToShowTopBar(currentScreen: AppScreen): Boolean {
    return !(currentScreen == AppScreen.LoginScreen ||
            currentScreen == AppScreen.GetCodeScreen ||
            currentScreen == AppScreen.ConfirmationScreen)
}

enum class AppScreen {
    LoginScreen,
    GetCodeScreen,
    ConfirmationScreen,
    MainScreen
}