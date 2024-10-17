package com.example.zweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.zweather.app.presentation.Navigator
import com.example.zweather.app.presentation.screens.home.HomeScreen
import com.example.zweather.ui.theme.ZweatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZweatherTheme {
                Navigator()

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
