package com.example.zweather.app.presentation.screens.search.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.zweather.app.domain.WeatherData

@Composable
fun TopRow(weatherData: WeatherData?) {
    val cityName = weatherData?.location?.name ?: "waiting.."
    val countyName = weatherData?.location?.country ?: "waiting.."
    val currentDegree = weatherData?.current?.tempC?.toInt() ?: ""
    val maxtc = weatherData?.forecast?.forecastday?.get(0)?.day?.maxtempC ?: ".."
    val mintc = weatherData?.forecast?.forecastday?.get(0)?.day?.mintempC ?: ".."
    val locationName = "$cityName,$countyName"
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(30.dp)) {
            Text(
                text = "H:$maxtc° L:$mintc°",
                style = MaterialTheme.typography.titleMedium,
                color = Color.LightGray
            )
            Text(
                text = "$cityName,${if (locationName.length > 15) "\n" else ""}$countyName",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        }
        Text(
            text = "$currentDegree°",
            style = MaterialTheme.typography.displayMedium,
            color = Color.White
        )
    }
}
