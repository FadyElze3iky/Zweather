package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zweather.app.domain.WeatherData
import com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics.ForecastData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SheetContent(weatherData: WeatherData?, sheetState: BottomSheetScaffoldState) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxHeight(.85f)
            .fillMaxWidth()
            .padding(top = 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        AnimatedVisibility(visible = sheetState.bottomSheetState.currentValue.toString() != "Expanded") {
            CustomTapRow(pagerState, coroutineScope)
        }
        AnimatedVisibility(visible = sheetState.bottomSheetState.currentValue.toString() != "Expanded") {
            CustomPager(pagerState, weatherData)

        }



        AnimatedVisibility(visible = sheetState.bottomSheetState.currentValue.toString() == "Expanded") {
            ForecastData(modifier = Modifier.verticalScroll(rememberScrollState()))

        }
    }
}


