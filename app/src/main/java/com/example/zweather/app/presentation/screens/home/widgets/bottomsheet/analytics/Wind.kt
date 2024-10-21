package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zweather.R
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Wind(modifier: Modifier, windDirection: String?, windSpeed: Double?) {

    val windDir =
        WindDirection.fromString(windDirection ?: "N")?.degree?.toDouble() ?: 90.0

    Box(modifier = modifier.padding(bottom = 15.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_compas),
            contentDescription = "compass",
            modifier = Modifier
                .size(140.dp)
                .align(Alignment.BottomCenter)
                .offset(y = 10.dp)

        )
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
                    painter = painterResource(id = R.drawable.wind),
                    contentDescription = "sun icon",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp),
                    colorFilter = ColorFilter.tint(color = Color.Gray)

                )
                Text(
                    text = "WIND",
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }


            Box(
                modifier = Modifier
                    .fillMaxSize() // Box for the entire wind direction view
                ,
                contentAlignment = Alignment.Center
            ) {
                // Hidden circle border and the small circle that moves along the border
                androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {

                    // Calculate position of the small circle based on windDegree
                    val angleRad = Math.toRadians(windDir) + Math.toRadians(90.0)
                    val centerX = size.width / 2
                    val centerY = size.height / 2
                    val circleRadius = size.minDimension - 180  // Adjust radius for padding

                    val x = (centerX + circleRadius * cos(angleRad)).toFloat()
                    val y = (centerY - circleRadius * sin(angleRad)).toFloat()

                    // Draw the small moving circle
                    drawCircle(
                        color = Color(0xffffffff),
                        radius = 15f, // Small circle size
                        center = Offset(x, y)
                    )
                }

//                 Display wind direction and degree
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = windSpeed.toString(),
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Km/h",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

            }

        }
    }
}

sealed class WindDirection(val degree: Float) {
    object N : WindDirection(0f)
    object NNE : WindDirection(22.5f)
    object NE : WindDirection(45f)
    object ENE : WindDirection(67.5f)
    object E : WindDirection(90f)
    object ESE : WindDirection(112.5f)
    object SE : WindDirection(135f)
    object SSE : WindDirection(157.5f)
    object S : WindDirection(180f)
    object SSW : WindDirection(202.5f)
    object SW : WindDirection(225f)
    object WSW : WindDirection(247.5f)
    object W : WindDirection(270f)
    object WNW : WindDirection(292.5f)
    object NW : WindDirection(315f)
    object NNW : WindDirection(337.5f)

    companion object {

        fun fromString(direction: String): WindDirection? {
            return when (direction.uppercase()) {
                "N" -> N
                "NNE" -> NNE
                "NE" -> NE
                "ENE" -> ENE
                "E" -> E
                "ESE" -> ESE
                "SE" -> SE
                "SSE" -> SSE
                "S" -> S
                "SSW" -> SSW
                "SW" -> SW
                "WSW" -> WSW
                "W" -> W
                "WNW" -> WNW
                "NW" -> NW
                "NNW" -> NNW
                else -> null // Return null for invalid directions
            }
        }
    }
}

