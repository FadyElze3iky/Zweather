package com.example.zweather.app.presentation.screens.search.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.zweather.R
import com.example.zweather.app.domain.WeatherData
import com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics.FeelsLike
import com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics.Rain
import com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics.Visibility

@Composable
fun ColumnScope.CustomBox(weatherData: WeatherData?) {

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val condition = weatherData?.current?.condition

    val smallBoxModifier = remember {
        Modifier
            .padding(5.dp)
            .shadow(
                elevation = 5.dp,
                ambientColor = Color(0xff000000),
                spotColor = Color(0xff000000),
                shape = RoundedCornerShape(20.dp),
                clip = true
            )
            .border(
                width = 1.dp,
                color = Color(0xff57467c),
                shape = RoundedCornerShape(
                    20.dp

                )
            )
            .clip(shape = RoundedCornerShape(20.dp))
            .size((screenWidth * .3).dp)

            .background(color = Color(0xff302757))
    }

    AnimatedVisibility(visible = weatherData?.location?.name != null) {
        Box(
            Modifier
                .fillMaxSize(.9f)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = R.drawable.searchrectangle),
                contentDescription = "rec",
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.BottomEnd,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )
            Column(
                modifier = Modifier.fillMaxWidth(.9f),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                TopRow(weatherData)
                MiddleRow(smallBoxModifier, weatherData)
                LastRow(condition)

            }
        }

    }
}


