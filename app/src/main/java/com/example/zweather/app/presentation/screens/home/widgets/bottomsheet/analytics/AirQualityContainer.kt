package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zweather.R
import com.example.zweather.app.domain.Current

@Composable
fun AirQualityContainer(current: Current?) {
    val airQuality = current?.airQuality

    var seeMore by remember {
        mutableStateOf(false)
    }

    if (airQuality != null) {

        val airQualityLevel = airQuality.gbDefraIndex

        val airQualityDescription = AirQualityLevel.getLevel(airQualityLevel ?: 1).description

        Box(
            modifier = Modifier
                .shadow(
                    elevation = 20.dp,
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
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.airqicon),
                        contentDescription = "air quality icon",
                        modifier = Modifier.padding(end = 10.dp)
                    )
                    Text(
                        text = "AIR QUALITY",
                        color = Color.Gray,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "$airQualityLevel-$airQualityDescription",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 15.dp)
                )
                // Box to create the visual bar
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
                                x = ((airQualityLevel ?: 1) * 30).dp
                            )
                            .clip(shape = CircleShape)
                            .size(7.dp)
                            .background(Color.White)
                    )
                }



                AnimatedVisibility(visible = seeMore) {

                    Column {
                        Text(
                            modifier = Modifier.padding(top = 10.dp),
                            text = "Co: ${airQuality.co}",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Text(
                            modifier = Modifier.padding(top = 10.dp),
                            text = "No2: ${airQuality.no2}",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Text(
                            modifier = Modifier.padding(top = 10.dp),
                            text = "O3: ${airQuality.o3}",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Text(
                            modifier = Modifier.padding(top = 10.dp),
                            text = "So2: ${airQuality.so2}",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }

                }




                HorizontalDivider(
                    modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
                    color = Color.Gray
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            seeMore = !seeMore
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Text(
                        text = "See More",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    if (!seeMore) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "arrow icon",
                            tint = Color.White
                        )
                    }
                    else {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "arrow icon",
                            tint = Color.White
                        )
                    }
                }

            }
        }
    }
    else {
        CircularProgressIndicator()
    }

}

sealed class AirQualityLevel(val description: String) {

    object Good : AirQualityLevel("Good")
    object LowHealthRisk : AirQualityLevel("Low health risk")
    object ModerateHealthRisk : AirQualityLevel("Moderate health risk")
    object HighHealthRisk : AirQualityLevel("High health risk")
    object VeryHighHealthRisk : AirQualityLevel("Very high health risk")
    object ExtremelyHighHealthRisk : AirQualityLevel("Extremely high health risk")

    companion object {

        fun getLevel(index: Int): AirQualityLevel {
            return when (index) {
                1 -> Good
                2 -> LowHealthRisk
                3, 4, 5 -> ModerateHealthRisk
                6, 7 -> HighHealthRisk
                8, 9 -> VeryHighHealthRisk
                10 -> ExtremelyHighHealthRisk
                else -> throw IllegalArgumentException("Invalid air quality index")
            }
        }
    }
}
