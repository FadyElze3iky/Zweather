package com.example.zweather.app.presentation.screens.home.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentWeatherView(sheetState: BottomSheetScaffoldState, modifier: Modifier) {
    Column(
        modifier = modifier,

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(visible = sheetState.bottomSheetState.currentValue.toString() == "PartiallyExpanded") {

            CurrentWeatherWidget()
        }


        AnimatedVisibility(visible = sheetState.bottomSheetState.currentValue.toString() != "PartiallyExpanded") {
            CurrentWeatherWidgetExpanded()

        }

    }
}
