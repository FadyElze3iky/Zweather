package com.example.zweather.app.presentation.screens.search.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.zweather.R
import com.example.zweather.app.domain.Condition

@Composable
fun LastRow(condition: Condition?) {
    val iconUrl = "https:${condition?.icon}"

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(.7f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            AsyncImage(
                model = iconUrl,
                contentDescription = "Condition icon",
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = condition?.text ?: "",
                modifier = Modifier
                    .padding(bottom = 50.dp),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )

        }

    }
}