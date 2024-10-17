package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.zweather.app.data.Forecastday

@Composable
fun WeekItem(
    it: Int,
    dayForecast: Forecastday?,
) {
    val serverDate = dayForecast?.date?.split("-")
    val date = "${serverDate?.get(1)}/${serverDate?.get(2)}"
    val maxDegree = dayForecast?.day?.maxtempC
    val minDegree = dayForecast?.day?.mintempC


    if (dayForecast != null) {
        Box(
            modifier = Modifier
                .padding(
                    start = 6.dp, end = 6.dp, bottom = 40.dp, top = 20.dp
                )
                .border(
                    width = 1.dp,
                    color = Color(0xff4d4688),
                    shape = RoundedCornerShape(50.dp)
                )
                .shadow(
                    elevation = 30.dp,
                    shape = RoundedCornerShape(50.dp),
                    ambientColor = Color(0xff000000),
                    spotColor = Color(0xffa17e7e),
                )
                .clip(shape = RoundedCornerShape(50.dp))

                .height(150.dp)
                .width(70.dp)
                .background(
                    color = if (it != 0) Color(0x8136335d) else Color(0x457E70AF)

                )

        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = date,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
                Column {
                    Text(
                        text = "H:${maxDegree?.toInt()}°",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "L:${minDegree?.toInt()}°",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

            }
        }
    }
    else {
        CircularProgressIndicator()
    }

}