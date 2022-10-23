package com.example.fishingshopcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fishingshopcompose.R
import com.example.fishingshopcompose.ui.screens.common.BottomButton
import com.example.fishingshopcompose.ui.screens.common.BottomButtonArgs
import com.example.fishingshopcompose.ui.theme.FishingShopComposeTheme
import com.example.fishingshopcompose.ui.theme.avenirNextFamily

@Composable
fun GetCodeScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.bg_get_code_screen),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = modifier.fillMaxSize()
        )
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 104.dp)
            )
            PhoneNumberInput()
            BottomButton(bottomButtonArgs = BottomButtonArgs(stringResource(R.string.scr_get_code_screen_get_code_btn)) {})
        }
    }
}

@Composable
fun Title(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(R.string.scr_get_code_screen_authorization_title),
            color = Color.White,
            fontSize = 48.sp,
            fontFamily = avenirNextFamily,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.scr_get_code_screen_phone_number_title),
            color = Color.White,
            fontSize = 31.sp,
            fontFamily = avenirNextFamily,
            fontWeight = FontWeight.Light
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PhoneNumberInput(modifier: Modifier = Modifier) {
    val text = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        modifier = modifier,
        value = text.value,
        onValueChange = { if (checkPhoneNumberLength(it)) text.value = it },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Done
        ),
        textStyle = TextStyle(color = Color.White, fontSize = 33.sp),
        keyboardActions = KeyboardActions(onDone = {
            if (validatePhoneNumber(text.value))
                keyboardController?.hide()
        }),
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.White,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White
        )
    )
}

fun checkPhoneNumberLength(text: String): Boolean {
    if (text.startsWith("+") && text.length <= 12) return true
    if (text.length <= 11) return true
    return false
}

fun validatePhoneNumber(text: String): Boolean {
    if (text.startsWith("+") && text.length < 12) return false
    if (text.length < 11) return false
    return true
}

@Preview(showBackground = true)
@Composable
fun GetCodeScreenPreview() {
    FishingShopComposeTheme {
        GetCodeScreen()
    }
}