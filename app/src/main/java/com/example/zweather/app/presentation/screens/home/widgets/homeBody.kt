package com.example.zweather.app.presentation.screens.home.widgets

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zweather.R
import com.example.zweather.app.presentation.WeatherViewModel

@SuppressLint("InvalidColorHexValue")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeBody(viewModel: WeatherViewModel = hiltViewModel(), sheetState: BottomSheetScaffoldState) {

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.daybackground),
            contentDescription = "background image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((LocalConfiguration.current.screenHeightDp * .55).dp)
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
                .padding(bottom = (LocalConfiguration.current.screenHeightDp * .2).dp),
            painter = painterResource(id = R.drawable.house),
            contentDescription = "house",
            contentScale = ContentScale.FillWidth
        )

        CurrentWeatherView(sheetState, modifier = Modifier.align(Alignment.TopCenter))

    }

}
