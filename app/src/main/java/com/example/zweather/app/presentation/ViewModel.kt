package com.example.zweather.app.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zweather.app.domain.GetWeatherUseCase
import com.example.zweather.app.domain.WeatherData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
) : ViewModel() {

    var _weatherState = MutableStateFlow<WeatherData?>(null)
    val weatherState: StateFlow<WeatherData?> = _weatherState

    private val _searchWeatherState = MutableStateFlow<WeatherData?>(null)
    val searchWeatherState: StateFlow<WeatherData?> = _searchWeatherState

    private var fusedLocationClient: FusedLocationProviderClient? = null

    // Add a loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    // Initialize the FusedLocationProviderClient
    fun initializeLocationClient(context: Context) {
        viewModelScope.launch {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
            getCurrentLocation(context)
        }

    }

    @SuppressLint("MissingPermission")  // Ensure permissions are handled in the UI layer
    fun getCurrentLocation(context: Context) {
        fusedLocationClient?.let { client ->
            client.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,  // Request high accuracy for location
                null  // No specific cancellation token is required here
            ).addOnSuccessListener { location: Location? ->
                if (location != null) {

                    val currentLocation = "${location.latitude},${location.longitude}"

                    fetchWeather(currentLocation, context)
                }
                else {
                    Toast.makeText(context, "Location not available", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Toast.makeText(context, "Failed to get current location", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchWeather(location: String, context: Context) {
        viewModelScope.launch {
            try {
                val data = getWeatherUseCase(location, 7)

                _weatherState.value = data

            } catch (e: Exception) {
                Toast.makeText(context, "Network or server error", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }

    fun searchWeather(location: String, context: Context) {

        viewModelScope.launch {
            try {
                _isLoading.value = true

                val data = getWeatherUseCase(location, 7)
                _isLoading.value = false

                _searchWeatherState.value = data

            } catch (e: Exception) {
                Toast.makeText(context, "Network or server error", Toast.LENGTH_SHORT).show()

                e.printStackTrace()
            }
        }
    }

}
