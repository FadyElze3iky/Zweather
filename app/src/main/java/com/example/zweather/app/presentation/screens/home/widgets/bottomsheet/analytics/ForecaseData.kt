package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ForecastData(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(.9f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(30.dp))
        AirQualityContainer(modifier = Modifier)
        Spacer(modifier = Modifier.height(30.dp))

    }
}
