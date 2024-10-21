package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable

@SuppressLint("UnrememberedMutableState")
@Composable
fun HourForecastView(forecastday: com.example.zweather.app.domain.Forecastday?, hour: Int?) {

    val hourList = forecastday?.hour


    LazyRow(state = LazyListState(firstVisibleItemIndex = hour ?: 0)) {
        items(count = 24) {
            val checkDay = if (it < 12) "AM" else "PM"
            val to12 = if (it < 12) it + 1 else it - 11

            HourItem(

                hourList?.get(it),
                it,
                hour,
                to12,
                checkDay,

                )
        }
    }

}
