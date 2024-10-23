package com.example.zweather.app.presentation.screens.home.widgets

import android.annotation.SuppressLint
import android.view.SoundEffectConstants
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.zweather.R
import com.example.zweather.app.presentation.WeatherViewModel

@SuppressLint("InvalidColorHexValue")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeBody(

    sheetState: BottomSheetScaffoldState,
    viewModel: WeatherViewModel,
) {
    val weatherData = viewModel.weatherState.collectAsState().value
    val lastupdate = weatherData?.current?.lastUpdated
    val view = LocalView.current // Get the current view to access sound feedback
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.daybackground),
            contentDescription = "background image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )

        if (weatherData != null) {
            if (weatherData.current?.isDay == 0) {
                Image(
                    painter = painterResource(id = R.drawable.backimage),
                    contentDescription = "background image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillWidth
                )

            }
        }




        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((LocalConfiguration.current.screenHeightDp * .6).dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,  // Ending with transparency
                            Color(0xff302857), // Starting color
                            Color(0xff302857), // Starting color

                        ),
                    ),
                )
                .align(Alignment.BottomCenter)
                .shadow(
                    elevation = 100.dp,
                    ambientColor = Color(0xff302857),
                    spotColor = Color(0xff302857),
                )
        )

        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = (LocalConfiguration.current.screenHeightDp * .23).dp),
            painter = painterResource(id = R.drawable.house),
            contentDescription = "house",
            contentScale = ContentScale.FillWidth
        )

        CurrentWeatherView(
            weatherData = weatherData,
            sheetState = sheetState,
            modifier = Modifier.align(Alignment.TopCenter)
        )



        AnimatedVisibility(
            visible = sheetState.bottomSheetState.currentValue.toString() == "PartiallyExpanded",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 30.dp, top = 50.dp)
        ) {

            Row {
                Text(text = lastupdate ?: "", color = Color.LightGray)
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "refresh icon",
                    tint = Color.LightGray,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() }, // No interaction source
                            indication = null // No visual indication (no ripple effect)
                        ) {
                            view.playSoundEffect(SoundEffectConstants.CLICK)
                            viewModel.initializeLocationClient(context)
                            Toast
                                .makeText(context, "Weather updating..", Toast.LENGTH_SHORT)
                                .show()

                        })

            }

        }
    }

}
