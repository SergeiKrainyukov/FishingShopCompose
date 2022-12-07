package com.example.fishingshopcompose.ui.screens.mainScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fishingshopcompose.R
import com.example.fishingshopcompose.ui.theme.FishingShopComposeTheme
import com.example.fishingshopcompose.ui.theme.avenirNextFamily

@Composable
fun MainScreen(modifier: Modifier = Modifier, viewModel: MainScreenViewModel) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
    ) {
        val (titleItem) = createRefs()
        Title(
            modifier = modifier
                .padding(20.dp)
                .constrainAs(titleItem) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
    }
}

@Composable
private fun Title(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.scr_main_screen_title),
        color = Color.White,
        fontSize = 36.sp,
        fontFamily = avenirNextFamily,
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
fun MainScreenPreview(){
    FishingShopComposeTheme {
        MainScreen(viewModel = hiltViewModel())
    }
}