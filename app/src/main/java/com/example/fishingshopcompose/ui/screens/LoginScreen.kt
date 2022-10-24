package com.example.fishingshopcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.fishingshopcompose.R
import com.example.fishingshopcompose.ui.screens.common.BottomButton
import com.example.fishingshopcompose.ui.screens.common.BottomButtonArgs
import com.example.fishingshopcompose.ui.theme.FishingShopComposeTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier, onAuthButtonClicked: () -> Unit) {
    Box(modifier = modifier, contentAlignment = Alignment.BottomCenter) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.bg_splash_screen),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(id = R.drawable.ic_fishing_shop),
                contentDescription = null,
            )
        }
        BottomButton(
            modifier,
            BottomButtonArgs(
                text = stringResource(R.string.scr_login_screen_button_auth),
                onClick = { onAuthButtonClicked() })
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    FishingShopComposeTheme {
        LoginScreen(onAuthButtonClicked = {})
    }
}