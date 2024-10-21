package com.example.zweather.app.presentation.screens.home.widgets

import android.view.SoundEffectConstants
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zweather.R
import com.example.zweather.app.presentation.Screen

@Composable
fun SearchIcon(modifier: Modifier, navController: NavController) {

    val view = LocalView.current // Get the current view to access sound feedback

    Box(
        modifier = modifier
            .size(120.dp)

    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .shadow(
                    elevation = 20.dp,
                    shape = CircleShape,
                    spotColor = Color.White
                )
                .clip(shape = CircleShape)
                .size(80.dp)

        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .shadow(
                    elevation = 30.dp,
                    shape = CircleShape,
                    spotColor = Color(0xff000000)
                )
                .clip(shape = CircleShape)
                .size(80.dp)

        )
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .clickable {
                    view.playSoundEffect(SoundEffectConstants.CLICK)
                    navController.navigate(Screen.Search.route)

                }
                .size(80.dp)
                .background(color = Color.White)
                .align(Alignment.Center)

        ) {
            Image(
                painter = painterResource(id = R.drawable.iconsearch),
                contentDescription = "Search icon",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(30.dp)
            )
        }

    }
}