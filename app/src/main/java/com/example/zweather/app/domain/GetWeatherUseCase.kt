package com.example.zweather.app.domain

import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(location: String, days: Int): WeatherData {
        return weatherRepository.getWeather(location, days)
    }
}
