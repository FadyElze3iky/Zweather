package com.example.zweather.app.presentation.screens.splash

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.zweather.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashCompleted: () -> Unit,
//    viewModel: WeatherViewModel = hiltViewModel()
) {

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



    LaunchedEffect(Unit) {
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )

        // Delay for splash screen duration
        delay(5000)

        onSplashCompleted()  // Trigger navigation to Home screen
    }

    val cloudPainter: Painter = painterResource(id = R.drawable.ic_cloud)
    val sunPainter: Painter = painterResource(id = R.drawable.ic_sun)

    // Create vibration animation
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val vibrationOffset by infiniteTransition.animateValue(
        initialValue = -12.dp, // Starting position
        targetValue = 12.dp,   // Ending position (vibration extent)
        typeConverter = Dp.VectorConverter, // Animation in dp
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1400, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xff644e95),  // Light Blue
                        Color(0xff3e2b83),  // Blue
                        Color(0xff2f3155),  // Darker Blue
                    ),
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Box(
                contentAlignment = Alignment.Center
            ) {
                // Sun image at the center
                Image(
                    painter = sunPainter,
                    contentDescription = "Sun",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(100.dp)
                        .offset(y = -45.dp, x = -40.dp)
                        .offset(y = vibrationOffset, x = vibrationOffset)
                )

                // Cloud image moving from left to right
                Image(
                    painter = cloudPainter,
                    contentDescription = "Cloud",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(220.dp)
                        .offset(x = -vibrationOffset)
                )

            }
            Text(
                text = "Z Weather",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.displaySmall.copy(
                    shadow = Shadow(
                        color = Color.DarkGray,
                        offset = Offset(
                            x = 5f, y = 10f
                        ),
                        blurRadius = 30f
                    )
                ),
                fontWeight = FontWeight.ExtraBold,

                )
        }

        Text(
            text = "@fadyelze3iky",
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        )

    }
    // Simulate splash duration and navigate to Home screen after a delay

}
