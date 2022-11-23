package com.example.fishingshopcompose.ui.common.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fishingshopcompose.R
import com.example.fishingshopcompose.ui.theme.Brown
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopAppBar(
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope
) {
    TopAppBar(
        title = {
            TopAppBarContent()
        },
        backgroundColor = Brown,
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch { scaffoldState.drawerState.open() }
            }) {
                Icon(
                    painterResource(id = R.drawable.ic_menu),
                    tint = MaterialTheme.colors.onPrimary,
                    contentDescription = null
                )
            }
        },
    )
}

@Composable
private fun TopAppBarContent(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = modifier)
        Image(
            painter = painterResource(id = R.drawable.ic_logo_fishing_shop),
            contentDescription = null,
            modifier = modifier.padding(end = 20.dp, bottom = 5.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_favorite),
            tint = Color.White,
            contentDescription = null,
            modifier = modifier.padding(end = 15.dp)
        )
    }
}