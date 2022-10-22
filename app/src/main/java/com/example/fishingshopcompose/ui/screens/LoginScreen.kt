package com.example.fishingshopcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fishingshopcompose.ui.theme.Green
import com.example.fishingshopcompose.ui.theme.avenirNextFamily
import com.example.fishingshopcompose.R
import com.example.fishingshopcompose.ui.theme.FishingShopComposeTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
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
        Button(
            modifier = modifier
                .padding(bottom = 93.dp)
                .height(65.dp)
                .width(246.dp),
            shape = RoundedCornerShape(
                topStartPercent = 5,
                topEndPercent = 25,
                bottomEndPercent = 5,
                bottomStartPercent = 25
            ),
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Green
            )
        ) {
            Text(
                text = stringResource(R.string.scr_button_auth),
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = avenirNextFamily,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    FishingShopComposeTheme {
        LoginScreen()
    }
}