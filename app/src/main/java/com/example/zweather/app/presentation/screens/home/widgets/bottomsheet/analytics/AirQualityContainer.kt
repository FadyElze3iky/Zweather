package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zweather.R

@Composable
fun AirQualityContainer(modifier: Modifier) {
    Box(
        modifier = modifier
            .shadow(
                elevation = 20.dp,
                ambientColor = Color(0xff5d4ea5),
                spotColor = Color(0xff57467c)
            )
            .border(
                width = 1.dp,
                color = Color(0xff57467c),
                shape = RoundedCornerShape(
                    20.dp

                )
            )

            .clip(shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()

            .background(color = Color(0xff302757))
            .padding(vertical = 20.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .fillMaxHeight(.8f)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.Start
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.airqicon),
                    contentDescription = "air quality icon",
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(
                    text = "AIR QUALITY",
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold
                )
            }

        }
    }
}
