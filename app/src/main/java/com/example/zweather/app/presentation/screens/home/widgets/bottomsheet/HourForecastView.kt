package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import com.example.zweather.app.data.Forecastday
import java.time.LocalTime

@SuppressLint("UnrememberedMutableState")
@Composable
fun HourForecastView(forecastday: Forecastday?) {

    val hourList = forecastday?.hour

    val hour = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalTime.now().hour
    }
    else {
        TODO("VERSION.SDK_INT < O")
    }

    val lazyListState = rememberLazyListState(initialFirstVisibleItemIndex = hour)

    LazyRow(state = lazyListState) {
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
