package com.example.fishingshopcompose.ui.screens.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.fishingshopcompose.R

@Composable
fun MainScreen(viewModel: MainScreenViewModel, modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
    ) {
        val (backgroundItem, titleItem, pinTitleItem, phoneNumberInputItem, resendCodeButtonItem, resendCodeTimerItem, bottomButtonItem) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.bg_confirmation_screen),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = modifier
                .fillMaxSize()
                .constrainAs(backgroundItem) {
                    centerVerticallyTo(parent)
                    centerHorizontallyTo(parent)
                }
        )
    }
}