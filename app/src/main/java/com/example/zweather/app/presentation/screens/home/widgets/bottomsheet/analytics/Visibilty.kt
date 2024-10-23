package com.example.zweather.app.presentation.screens.home.widgets.bottomsheet.analytics

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zweather.R
import com.example.zweather.app.domain.Current

@Composable
fun Visibility(modifier: Modifier, current: Current?, fromSearch: Boolean = false) {

    val visibility = current?.visKm
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .fillMaxHeight(.8f)
                .align(Alignment.Center)
                .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_visibility),
                        contentDescription = "Visibility",
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(18.dp),
                        colorFilter = ColorFilter.tint(color = Color.Gray)
                    )
                    Text(
                        text = "VISIBILITY",
                        color = Color.Gray,
                        style = if (!fromSearch) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (!fromSearch) {
                    Text(
                        text = "$visibility KM",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(top = 5.dp)
                    )
                }
                else {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "$visibility",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 5.dp)
                        )
                        Text(
                            text = "KM",
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 5.dp)
                        )
                    }
                }

            }

            if (!fromSearch) {
                Text(
                    text = "The distance one can clearly see in the current weather conditions.",
                    color = Color.LightGray,
                    style = MaterialTheme.typography.bodySmall,
                )
            }

        }
    }
}
