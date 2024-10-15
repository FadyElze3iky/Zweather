package com.example.zweather.app.presentation.screens.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.zweather.R

@Composable
fun BottomAppBar() {
    Box(modifier = Modifier.height(140.dp)) {

        Image(
            painter = painterResource(id = R.drawable.rectangle),
            contentDescription = "buttom bar",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(100.dp)
        )
        SearchIcon(modifier = Modifier.align(Alignment.TopCenter))
    }
}
