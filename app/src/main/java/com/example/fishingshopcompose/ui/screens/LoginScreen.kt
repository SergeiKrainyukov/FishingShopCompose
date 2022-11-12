package com.example.fishingshopcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.fishingshopcompose.R
import com.example.fishingshopcompose.ui.screens.common.BottomButton
import com.example.fishingshopcompose.ui.screens.common.BottomButtonArgs
import com.example.fishingshopcompose.ui.theme.FishingShopComposeTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier, onAuthButtonClicked: () -> Unit) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
    ) {
        val (backgroundItem, logoItem, bottomButtonItem) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.bg_splash_screen),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = modifier
                .fillMaxSize()
                .constrainAs(backgroundItem) {
                    centerVerticallyTo(parent)
                    centerHorizontallyTo(parent)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.ic_fishing_shop),
            contentDescription = null,
            modifier = modifier.constrainAs(logoItem) {
                centerVerticallyTo(parent)
                centerHorizontallyTo(parent)
            }
        )
        BottomButton(
            modifier = modifier
                .padding(15.dp)
                .constrainAs(bottomButtonItem) {
                    bottom.linkTo(parent.bottom)
                    centerHorizontallyTo(parent)
                },
            bottomButtonArgs = BottomButtonArgs(
                text = stringResource(R.string.scr_login_screen_button_auth),
                onClick = { onAuthButtonClicked() }),
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