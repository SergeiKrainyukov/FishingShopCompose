package com.example.fishingshopcompose.ui.common.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fishingshopcompose.R
import com.example.fishingshopcompose.ui.theme.Green
import com.example.fishingshopcompose.ui.theme.avenirNextFamily

@Composable
fun CustomBottomBar() {
    var selectedItem by remember { mutableStateOf(0) }

    val items = listOf(
        NavigationItem(0, R.drawable.ic_home, R.string.scr_main_screen_icon_lbl),
        NavigationItem(
            1,
            R.drawable.ic_fishing,
            R.string.scr_fishing_icon_lbl,
        ),
        NavigationItem(2, R.drawable.ic_basket, R.string.scr_basket_icon_lbl),
    )
    BottomNavigation(
        backgroundColor = Color.Transparent, elevation = 0.dp,
        modifier = Modifier.height(90.dp)
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = it.vectorResourceId),
                        contentDescription = stringResource(id = it.contentDescriptionResourceId),
                        tint = if (selectedItem == it.index) Color.White else Green,
                        modifier = Modifier
                            .background(
                                shape = RoundedCornerShape(
                                    topStartPercent = 20,
                                    topEndPercent = 20,
                                    bottomEndPercent = 20,
                                    bottomStartPercent = 20
                                ),
                                color = if (selectedItem == it.index) Green else Color.White,
                            )
                            .padding(if (it.index == 1) 12.dp else 15.dp)
                            .scale(if (it.index == 1) 0.8f else 1f)
                    )
                },
                selected = selectedItem == it.index,
                onClick = {
                    selectedItem = it.index
                },
                label = {
                    Text(
                        text = stringResource(id = it.contentDescriptionResourceId),
                        color = Color.White,
                        fontFamily = avenirNextFamily,
                        fontWeight = FontWeight.Medium,
                    )
                },
            )
        }
    }
}

data class NavigationItem(
    val index: Int,
    val vectorResourceId: Int,
    val contentDescriptionResourceId: Int,
)