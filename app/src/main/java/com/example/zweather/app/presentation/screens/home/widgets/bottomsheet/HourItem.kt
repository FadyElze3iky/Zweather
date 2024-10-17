package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import coil.compose.AsyncImage
import com.example.zweather.app.data.Hour

@Composable
fun HourItem(

    hourData: Hour?,
    it: Int,
    hour: Int,
    to12: Int,
    checkDay: String,

    ) {

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

            .height(130.dp)
            .width(60.dp)
            .background(
                color = if (it != hour) Color(0x8136335d) else Color(0x457E70AF)

            )

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = if (it != hour) "$to12 $checkDay" else "Now",
                color = Color.White,
                style = MaterialTheme.typography.titleSmall
            )


            if (hourData != null) {
                println(hourData.condition?.icon)
                val iconUrl = "https:${hourData.condition?.icon}"
                AsyncImage(
                    model = iconUrl,
                    contentDescription = "Condition icon",
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "${hourData.tempC.toString()}°",
                    color = Color.White,
                    style = MaterialTheme.typography.titleSmall
                )
            }
            else {
                CircularProgressIndicator()
            }

        }
    }
}