package com.example.zweather.app.presentation.screens.search.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zweather.app.domain.WeatherData
import com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics.FeelsLike
import com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics.Rain
import com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics.Visibility

@Composable
fun MiddleRow(
    smallBoxModifier: Modifier,
    weatherData: WeatherData?,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            FeelsLike(
                modifier = smallBoxModifier,
                current = weatherData?.current,
                fromSearch = true
            )
            Rain(
                modifier = smallBoxModifier,
                forecastday = weatherData?.forecast?.forecastday?.get(0),
                fromSearch = true
            )

        }
        Visibility(
            modifier = smallBoxModifier,
            current = weatherData?.current,
            fromSearch = true
        )
        Spacer(modifier = Modifier.width(15.dp))

    }
}