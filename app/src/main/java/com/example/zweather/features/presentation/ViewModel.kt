package com.example.zweather.features.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zweather.features.domain.GetWeatherUseCase
import com.example.zweather.features.domain.WeatherData
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
) : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherData?>(null)
    val weatherState: StateFlow<WeatherData?> = _weatherState

    fun fetchWeather(location: String, days: Int) {
        viewModelScope.launch {
            try {
                val data = getWeatherUseCase(location, days)
                _weatherState.value = data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
