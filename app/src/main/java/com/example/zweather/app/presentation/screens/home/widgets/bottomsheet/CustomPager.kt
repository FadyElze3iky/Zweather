package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun ColumnScope.CustomPager(pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        userScrollEnabled = false
    ) { page ->
        AnimatedVisibility(
            visible = page == 0,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            HourForecastView()
        }
        AnimatedVisibility(
            visible = page == 1,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            WeekForecastView()
        }

    }
}
