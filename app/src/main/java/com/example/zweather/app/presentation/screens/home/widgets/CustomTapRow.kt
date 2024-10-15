package com.example.zweather.app.presentation.screens.home.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomTapRow(
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
) {
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        contentColor = Color.LightGray,
        containerColor = Color.Transparent,
        divider = {},
        indicator = {
            TabRowDefaults.PrimaryIndicator(
                modifier = Modifier
                    .tabIndicatorOffset(it[pagerState.currentPage])
                    .shadow(
                        elevation = 50.dp,
                        ambientColor = Color(0xfffefaff),
                        spotColor = Color(0xfffefbff),

                        ),
                height = .5.dp,
                width = (LocalConfiguration.current.screenWidthDp * 0.4f).dp,
                color = Color(0xffbe8fdf)
            )
        }
    ) {
        Tab(
            selected = pagerState.currentPage == 0,
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(0)
                }
            },
            text = {
                Text(
                    text = "Hourly Forecast",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        )
        Tab(
            selected = pagerState.currentPage == 1,
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(1)
                }
            },
            text = {
                Text(
                    text = "Weekly Forecast",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        )

    }
}