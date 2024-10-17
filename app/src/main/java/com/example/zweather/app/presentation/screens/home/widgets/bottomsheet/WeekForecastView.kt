package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun WeekForecastView() {

    val hour = remember {
        mutableStateOf(5)
    }
    val degree = "19°"
    val state = "sunny"

    val lazyListState = rememberLazyListState(initialFirstVisibleItemIndex = hour.value)

    LazyRow(state = lazyListState) {
        items(count = 7) {

            WeekItem(it, hour.value, state, degree)
        }
    }
}
