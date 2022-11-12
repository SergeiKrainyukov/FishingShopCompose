package com.example.fishingshopcompose.ui.screens.common

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fishingshopcompose.ui.theme.Green
import com.example.fishingshopcompose.ui.theme.avenirNextFamily

@Composable
fun BottomButton(modifier: Modifier = Modifier, bottomButtonArgs: BottomButtonArgs) {
    Button(
        modifier = modifier
            .height(65.dp)
            .width(246.dp),
        shape = RoundedCornerShape(
            topStartPercent = 5,
            topEndPercent = 25,
            bottomEndPercent = 5,
            bottomStartPercent = 25
        ),
        onClick = bottomButtonArgs.onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Green
        )
    ) {
        Text(
            text = bottomButtonArgs.text,
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = avenirNextFamily,
            fontWeight = FontWeight.Bold
        )
    }
}

data class BottomButtonArgs(val text: String, val onClick: () -> Unit)