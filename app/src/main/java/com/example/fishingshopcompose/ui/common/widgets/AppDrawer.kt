package com.example.fishingshopcompose.ui.common.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fishingshopcompose.R
import com.example.fishingshopcompose.ui.theme.avenirNextFamily

@Composable
fun AppDrawer(closeDrawerAction: () -> Unit, modifier: Modifier = Modifier) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bg_drawer),
            contentScale = ContentScale.FillWidth,
            contentDescription = null
        )
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AppDrawerHeader(modifier = Modifier.padding(15.dp), closeDrawerAction)
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppDrawerBody(
                    closeDrawerAction,
                    modifier = Modifier.padding(start = 30.dp)
                )
                LogoutButton(
                    closeDrawerAction,
                    modifier = Modifier.padding(start = 30.dp)
                )
                AppDrawerFooter(modifier)
            }
        }
    }
}

@Composable
private fun AppDrawerHeader(modifier: Modifier = Modifier, closeDrawerAction: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = modifier)
        Image(
            painter = painterResource(id = R.drawable.ic_logo_fishing_shop),
            contentDescription = null
        )
        Icon(
            imageVector = Icons.Filled.Close,
            tint = Color.White,
            contentDescription = null,
            modifier = modifier.clickable {
                closeDrawerAction()
            })
    }
}

@Composable
private fun AppDrawerBody(closeDrawerAction: () -> Unit, modifier: Modifier) {
    Column(modifier = modifier) {
        ScreenNavigationButton(
            icon = ImageVector.vectorResource(id = R.drawable.ic_user),
            label = stringResource(R.string.scr_drawer_profile_btn_lbl),
            onClickAction = {
                closeDrawerAction()
            }
        )
        ScreenNavigationButton(
            icon = ImageVector.vectorResource(id = R.drawable.ic_favorite),
            label = stringResource(id = R.string.scr_drawer_favorites_btn_lbl),
            onClickAction = {
                closeDrawerAction()
            }
        )
        ScreenNavigationButton(
            icon = ImageVector.vectorResource(id = R.drawable.ic_settings),
            label = stringResource(id = R.string.scr_drawer_settings_btn_lbl),
            onClickAction = {
                closeDrawerAction()
            }
        )
    }
}

@Composable
private fun LogoutButton(closeDrawerAction: () -> Unit, modifier: Modifier) {
    ScreenNavigationButton(
        modifier = modifier,
        icon = ImageVector.vectorResource(id = R.drawable.ic_logout),
        label = stringResource(id = R.string.scr_drawer_logout_btn_lbl),
        onClickAction = {
            closeDrawerAction()
        }
    )
}

@Composable
private fun ScreenNavigationButton(
    icon: ImageVector,
    label: String,
    onClickAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClickAction,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                modifier = Modifier.padding(top = 5.dp),
                imageVector = icon,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = label
            )
            Spacer(Modifier.width(16.dp))
            Text(
                fontSize = 18.sp,
                text = label,
                fontFamily = avenirNextFamily,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }
}

@Composable
private fun AppDrawerFooter(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(start = 16.dp, bottom = 10.dp)
    ) {
        Text(
            text = stringResource(id = R.string.scr_drawer_footer_title),
            color = Color.White,
            fontFamily = avenirNextFamily,
            fontWeight = FontWeight.Medium,
        )
        Text(
            text = stringResource(id = R.string.scr_drawer_footer_shop),
            color = Color.White,
            fontFamily = avenirNextFamily,
            fontWeight = FontWeight.Medium,
        )
    }

}

@Preview
@Composable
fun AppDrawerPreview() {
    AppDrawer(closeDrawerAction = {})
}