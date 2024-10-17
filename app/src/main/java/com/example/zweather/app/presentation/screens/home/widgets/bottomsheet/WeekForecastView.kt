package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.zweather.app.data.Forecastday

@Composable
fun WeekForecastView(weaklyForecast: List<Forecastday>?) {

    val degree = "19°"
    val state = "sunny"


    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        WeekItem(0, weaklyForecast?.get(0))
        WeekItem(1, weaklyForecast?.get(1))
        WeekItem(2, weaklyForecast?.get(2))

    }

}
