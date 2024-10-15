package com.example.zweather.app.presentation.screens.home.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ForecastData(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.White)
        )
        Spacer(modifier = Modifier.height(33.dp))
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.White)
        )
        Spacer(modifier = Modifier.height(33.dp))

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.White)
        )
        Spacer(modifier = Modifier.height(33.dp))

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.White)
        )
        Spacer(modifier = Modifier.height(33.dp))

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.White)
        )
        Spacer(modifier = Modifier.height(33.dp))

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.White)
        )
        Spacer(modifier = Modifier.height(33.dp))

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color = Color.White)
        )

    }
}
