package com.example.zweather.app.presentation.screens.home.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CurrentWeatherWidgetExpanded() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier

    ) {

        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Cairo", fontSize = 40.sp, color = Color.White)

        Row {
            Text(
                text = "19°",
                fontSize = 20.sp,
                color = Color.LightGray,
                fontWeight = FontWeight.Light
            )
            Text(
                text = " | Mostly Clear", fontSize = 20.sp,
                color = Color.LightGray,
                fontWeight = FontWeight.Light
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(8.dp)
                .shadow(
                    elevation = 90.dp,
                    ambientColor = Color(0xffe5a9ff), spotColor = Color(0xffe5a9ff)
                )

        )

    }

}