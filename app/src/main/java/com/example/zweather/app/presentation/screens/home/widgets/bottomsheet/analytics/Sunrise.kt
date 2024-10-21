package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zweather.R
import com.example.zweather.app.domain.Forecastday

@Composable
fun Sunrise(modifier: Modifier, forecastday: Forecastday?) {

    val sunrisedate = remember { forecastday?.astro?.sunrise }
    val sunset = remember { forecastday?.astro?.sunset }

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .fillMaxHeight(.8f)
                .align(Alignment.Center)
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Sunrise icon and text
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sunriseicon),
                    contentDescription = "Sunrise",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp),
                    colorFilter = ColorFilter.tint(color = Color.Gray)
                )
                Text(
                    text = "SUN RISE",
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            // Sunrise Time
            Text(
                text = sunrisedate ?: "",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "Sunset: $sunset",
                color = Color.LightGray,
                style = MaterialTheme.typography.titleSmall,
            )

        }
    }
}
