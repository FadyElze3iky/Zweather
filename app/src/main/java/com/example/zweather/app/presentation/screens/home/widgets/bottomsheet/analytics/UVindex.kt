package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zweather.R

@Composable
fun UVindex(modifier: Modifier, uvIndex: Double?) {

    val uvdisc = remember { UVIndex.fromValue(uvIndex ?: 0.0) }
    Box(modifier = modifier.padding(bottom = 15.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .fillMaxHeight(.8f)
                .align(Alignment.Center)
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.sunicon),
                    contentDescription = "sun icon",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp),
                    colorFilter = ColorFilter.tint(color = Color.Gray)

                )
                Text(
                    text = "UV INDEX",
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Column {
                Text(
                    text = uvIndex.toString(),
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = uvdisc.description,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)

                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xff16538f), Color.Magenta)
                        ),
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                // The indicator for the air quality value
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)  // Align according to the value
                        .offset(
                            x = ((uvIndex ?: 1.0) * 15).dp
                        )
                        .clip(shape = CircleShape)
                        .size(7.dp)
                        .background(Color.White)
                )
            }
        }
    }
}

sealed class UVIndex(val value: Double, val description: String, val riskLevel: String) {
    object Low : UVIndex(0.0, "Low", "Minimal risk")
    object Moderate : UVIndex(3.0, "Moderate", "Low to moderate risk")
    object High : UVIndex(6.0, "High", "Moderate to high risk")
    object VeryHigh : UVIndex(8.0, "Very High", "High risk of harm from unprotected exposure")
    object Extreme : UVIndex(11.0, "Extreme", "Extreme risk, avoid exposure")

    companion object {

        fun fromValue(value: Double): UVIndex {
            return when {
                value <= 2.0 -> Low
                value in 3.0..5.9 -> Moderate
                value in 6.0..7.9 -> High
                value in 8.0..10.9 -> VeryHigh
                else -> Extreme
            }
        }
    }
}