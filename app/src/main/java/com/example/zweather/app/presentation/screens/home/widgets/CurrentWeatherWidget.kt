package com.example.zweather.app.presentation.screens.home.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CurrentWeatherWidget() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Cairo", fontSize = 40.sp, color = Color.White)

        Text(
            text = "19°",
            fontSize = 90.sp,
            color = Color.White,
            fontWeight = FontWeight.Light
        )
        Text(text = "Mostly Clear", fontSize = 25.sp, color = Color.LightGray)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "H:20° L:12°", fontSize = 20.sp, color = Color.White)

    }
}
