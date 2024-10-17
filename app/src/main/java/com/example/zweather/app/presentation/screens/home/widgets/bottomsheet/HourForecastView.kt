package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@SuppressLint("UnrememberedMutableState")
@Composable
fun HourForecastView() {

    val hour = remember {
        mutableStateOf(12)
    }
    val degree = "19°"
    val state = "sunny"

    val lazyListState = rememberLazyListState(initialFirstVisibleItemIndex = hour.value)

    LazyRow(state = lazyListState) {
        items(count = 24) {
            val checkDay = if (it < 12) "AM" else "PM"
            val to12 = if (it < 12) it + 1 else it - 11

            HourItem(it, hour.value, to12, checkDay, degree)
        }
    }

}
