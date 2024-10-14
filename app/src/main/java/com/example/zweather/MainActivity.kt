package com.example.zweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zweather.features.presentation.WeatherViewModel
import com.example.zweather.ui.theme.ZweatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZweatherTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    ChickApi(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ZweatherTheme {

    }
}

@Composable
fun ChickApi(viewModel: WeatherViewModel = hiltViewModel(), modifier: Modifier) {

    val weather by viewModel.weatherState.collectAsState()

    Column(modifier) {
        Button(onClick = {
            viewModel.fetchWeather("Cairo", 3)
            println("ffffffffffffffffffffffff")
        }) {
            Text(text = "click")
        }

        Text(text = weather?.current?.condition?.text ?: "")

    }

}