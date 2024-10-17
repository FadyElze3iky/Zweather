package com.example.zweather.app.presentation.screens.splash

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.zweather.app.presentation.WeatherViewModel

@Composable
fun SplashScreen(onSplashCompleted: () -> Unit, viewModel: WeatherViewModel = hiltViewModel()) {

    val context = LocalContext.current

    // Launcher to request permissions
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val fineLocationGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        val coarseLocationGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false

        if (!fineLocationGranted || !coarseLocationGranted) {
            // Permissions granted, proceed to fetch location and weather
            Toast.makeText(context, "Location permission is denied", Toast.LENGTH_SHORT).show()

        }
        
    }




    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome to ZWeather!",
            textAlign = TextAlign.Center
        )
    }

    // Simulate splash duration and navigate to Home screen after a delay
    LaunchedEffect(Unit) {

        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
        kotlinx.coroutines.delay(3000) // Delay for 2 seconds
        onSplashCompleted()  // Trigger navigation to Home screen
    }
}
