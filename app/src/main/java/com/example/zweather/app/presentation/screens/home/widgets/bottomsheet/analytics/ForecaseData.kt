package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.zweather.app.domain.WeatherData

@Composable
fun ForecastData(modifier: Modifier, weatherData: WeatherData?) {
    val uvindex = weatherData?.current?.uv
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val forecastday = weatherData?.forecast?.forecastday?.get(0)
    val smallBoxModifier = remember {
        Modifier
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

            .height(180.dp)
            .width((screenWidth * .42).dp)
            .background(color = Color(0xff302757))
    }


    Column(
        modifier = modifier
            .fillMaxWidth(.9f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        AirQualityContainer(current = weatherData?.current)
        Spacer(modifier = Modifier.height(15.dp))
        UVandSunrise(modifier = smallBoxModifier, uvindex = uvindex, forecastday = forecastday)
        Spacer(modifier = Modifier.height(15.dp))

        WindAndRain(
            modifier = smallBoxModifier,

            forecastday = forecastday,
            current = weatherData?.current
        )
        Spacer(modifier = Modifier.height(15.dp))
        FeelsAndHumidity(
            modifier = smallBoxModifier,
            current = weatherData?.current
        )
        Spacer(modifier = Modifier.height(15.dp))
        VisibilityAndPressure(
            modifier = smallBoxModifier,
            current = weatherData?.current
        )
        Spacer(modifier = Modifier.height(15.dp))

    }
}
