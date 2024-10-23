package com.example.zweather.app.presentation.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.zweather.app.presentation.WeatherViewModel
import com.example.zweather.app.presentation.screens.search.widgets.SearchBody

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navController: NavController = rememberNavController(),
    viewModel: WeatherViewModel,
) {
    val weatherData = viewModel.searchWeatherState.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(

                title = {

                    Text(
                        text = weatherData?.location?.name ?: "Weather",
                        style = MaterialTheme.typography.headlineMedium
                    )

                },

                colors = TopAppBarColors(
                    containerColor = Color.Transparent,
                    actionIconContentColor = Color.Gray,
                    titleContentColor = Color.White,
                    scrolledContainerColor = Color.Transparent,
                    navigationIconContentColor = Color.LightGray
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                        viewModel._weatherState.value =
                            viewModel.searchWeatherState.value
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "",
                            modifier = Modifier.size(50.dp)
                        )
                    }
                }

            )
        }
    )
    {
        Box(
            modifier = Modifier
                .fillMaxSize()

                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xff2e335a),  // Light Blue
                            Color(0xff1c1b33),  // Blue
                        ),
                    )
                )

        ) {
            SearchBody(it, viewModel)
        }
    }
}

