package com.example.zweather.app.presentation.screens.search.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import com.example.zweather.app.presentation.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBody(it: PaddingValues, viewModel: WeatherViewModel) {
    val weatherData = viewModel.searchWeatherState.collectAsState().value

    val isLoadint = viewModel.isLoading.collectAsState().value
    Column(
        Modifier
            .fillMaxSize()
            .padding(it), verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchField(viewModel)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            if (weatherData?.location?.name == null && !isLoadint) {
                Text(
                    text = "Waiting for search",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(x = 4f, y = 4f),
                            blurRadius = 10f
                        )
                    )
                )
            }
            if (isLoadint) {
                LinearProgressIndicator()
            }
            CustomBox(weatherData)

        }
    }
}
