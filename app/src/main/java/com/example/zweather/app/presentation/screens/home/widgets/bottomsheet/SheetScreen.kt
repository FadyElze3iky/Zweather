package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.zweather.app.presentation.WeatherViewModel
import com.example.zweather.app.presentation.screens.home.widgets.HomeBody

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SheetScreen(
    viewModel: WeatherViewModel,
    sheetHeight: Float,
    sheetState: BottomSheetScaffoldState,
) {
    val weatherData = viewModel.weatherState.collectAsState().value
    BottomSheetScaffold(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        sheetContent = {

            SheetContent(weatherData, sheetState)

        },

        sheetPeekHeight = sheetHeight.dp,
        sheetContainerColor = Color(0xe72f2757),
        scaffoldState = sheetState,
        sheetShadowElevation = 10.dp,
        sheetShape = MaterialTheme.shapes.large.copy(
            topStart = CornerSize(40.dp),
            topEnd = CornerSize(40.dp),
            bottomEnd = CornerSize(0.dp),
            bottomStart = CornerSize(0.dp)
        ),
        sheetSwipeEnabled = true,
    )
    {

        HomeBody(sheetState = sheetState, viewModel = viewModel)

    }
}


