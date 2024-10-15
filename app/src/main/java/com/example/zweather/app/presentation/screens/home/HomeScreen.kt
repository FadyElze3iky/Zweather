@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.zweather.app.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zweather.app.presentation.WeatherViewModel
import com.example.zweather.app.presentation.screens.home.widgets.BottomAppBar
import com.example.zweather.app.presentation.screens.home.widgets.SheetScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    val sheetState =
        rememberBottomSheetScaffoldState(bottomSheetState = rememberStandardBottomSheetState())

    val sheetHeight = LocalConfiguration.current.screenHeightDp * 0.4f

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AnimatedVisibility(
                visible = (sheetState.bottomSheetState.currentValue.toString() == "PartiallyExpanded"),
                content = { BottomAppBar() }
            )

        }
    ) {
        SheetScreen(sheetHeight, sheetState)
    }

}



