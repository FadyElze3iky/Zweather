package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.zweather.app.domain.Current
import com.example.zweather.app.domain.Forecastday

@Composable
fun WindAndRain(
    modifier: Modifier,

    forecastday: Forecastday?,
    current: Current?,

    ) {

    val windDirection = current?.windDir
    val windSpeed = current?.windKph
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Wind(modifier, windDirection, windSpeed)
        Rain(modifier, forecastday)
    }
}


