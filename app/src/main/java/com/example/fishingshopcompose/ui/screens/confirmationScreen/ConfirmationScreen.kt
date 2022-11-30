package com.example.fishingshopcompose.ui.screens.confirmationScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fishingshopcompose.R
import com.example.fishingshopcompose.ui.common.widgets.BottomButton
import com.example.fishingshopcompose.ui.common.widgets.BottomButtonArgs
import com.example.fishingshopcompose.ui.theme.FishingShopComposeTheme
import com.example.fishingshopcompose.ui.theme.avenirNextFamily

@Composable
fun ConfirmationScreen(
    modifier: Modifier = Modifier,
    viewModel: ConfirmationScreenViewModel = viewModel(),
    onSuccessConfirmation: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
    ) {

        val confirmPinState by viewModel.confirmPinFlow.collectAsState()

        LaunchedEffect(confirmPinState) {
            if (confirmPinState == "success")
                onSuccessConfirmation()
        }

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
        Title(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
                .constrainAs(titleItem) {
                    top.linkTo(parent.top)
                    centerHorizontallyTo(parent)
                }
        )
        PinTitle(
            modifier = modifier
                .padding(bottom = 10.dp)
                .constrainAs(pinTitleItem) {
                    centerHorizontallyTo(parent)
                    bottom.linkTo(phoneNumberInputItem.top)
                })
        PinView(
            viewModel = viewModel,
            modifier = modifier.constrainAs(phoneNumberInputItem) {
                centerHorizontallyTo(parent)
                centerVerticallyTo(parent)
            })
        ResendCodeButton(
            modifier = modifier
                .padding(bottom = 20.dp)
                .constrainAs(resendCodeButtonItem) {
                    top.linkTo(phoneNumberInputItem.bottom)
                    bottom.linkTo(bottomButtonItem.top)
                    centerHorizontallyTo(parent)
                },
        )
        ResendCodeTimer(modifier = modifier.constrainAs(resendCodeTimerItem) {
            top.linkTo(resendCodeButtonItem.bottom)
            centerHorizontallyTo(parent)
        })
        BottomButton(
            modifier = modifier
                .padding(15.dp)
                .constrainAs(bottomButtonItem) {
                    bottom.linkTo(parent.bottom)
                    centerHorizontallyTo(parent)
                },
            bottomButtonArgs = BottomButtonArgs(stringResource(R.string.scr_confirmation_screen_confirm_button)) {
                viewModel.confirmPin()
            })
    }
}

@Composable
private fun Title(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(R.string.scr_confirmation_screen_title),
            color = Color.White,
            fontSize = 40.sp,
            fontFamily = avenirNextFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(R.string.scr_confirmation_screen_second_title),
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = avenirNextFamily,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun PinTitle(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.scr_confirmation_screen_pin_code_title),
        color = Color.White,
        fontSize = 18.sp,
        fontFamily = avenirNextFamily,
        fontWeight = FontWeight.Light
    )
}

@Composable
fun PinView(
    modifier: Modifier = Modifier,
    viewModel: ConfirmationScreenViewModel,
    digitColor: Color = Color.White,
    digitSize: TextUnit = 32.sp,
    containerSize: Dp = digitSize.value.dp * 2,
    digitCount: Int = 4,
) {
    val text = viewModel.pinTextFlow.collectAsState()
    BasicTextField(
        modifier = modifier,
        value = text.value,
        cursorBrush = SolidColor(Color.White),
        onValueChange = { viewModel.updateTextFlow(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                repeat(digitCount) { index ->
                    DigitView(index, text.value, digitColor, digitSize, containerSize)
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        })
}


@Composable
private fun DigitView(
    index: Int,
    pinText: String,
    digitColor: Color,
    digitSize: TextUnit,
    containerSize: Dp,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (index >= pinText.length) "" else pinText[index].toString(),
            color = digitColor,
            modifier = Modifier.width(containerSize),
            style = MaterialTheme.typography.body1,
            fontSize = digitSize,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(2.dp))
        Box(
            modifier = Modifier
                .background(digitColor)
                .height(1.dp)
                .width(containerSize)
        )
    }
}

@Composable
private fun ResendCodeButton(modifier: Modifier) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.ic_reload), contentDescription = null)
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = stringResource(id = R.string.scr_confirmation_screen_resend_code),
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = avenirNextFamily,
            fontWeight = FontWeight.Light
        )
    }
}

@Composable
private fun ResendCodeTimer(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "10" + stringResource(id = R.string.scr_confirmation_screen_seconds),
        color = Color.White,
        fontSize = 18.sp,
        fontFamily = avenirNextFamily,
        fontWeight = FontWeight.Light
    )
}

@Preview(showBackground = true)
@Composable
private fun GetCodeScreenPreview() {
    FishingShopComposeTheme {
        ConfirmationScreen(viewModel()) {}
    }
}