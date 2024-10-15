package com.example.zweather.app.domain

import com.example.zweather.app.data.Current

data class WeatherData(
    val location: Location?,
    val current: Current?,
    val forecast: List<com.example.zweather.app.data.Forecastday>?,
)

data class Location(
    val name: String?,
    val region: String?,
    val country: String?,
    val lat: Double?,
    val lon: Double?,
    val tzId: String?,
    val localtimeEpoch: Int?,
    val localtime: String?,
)

data class Current(
    val lastUpdatedEpoch: Int?,
    val lastUpdated: String?,
    val tempC: Double?,
    val tempF: Double?,
    val isDay: Int?,
    val condition: Condition?,
    val windMph: Double?,
    val windKph: Double?,
    val windDegree: Int?,
    val windDir: String?,
    val pressureMb: Double?,
    val pressureIn: Double?,
    val precipMm: Double?,
    val precipIn: Double?,
    val humidity: Int?,
    val cloud: Int?,
    val feelslikeC: Double?,
    val feelslikeF: Double?,
    val windchillC: Double?,
    val windchillF: Double?,
    val heatindexC: Double?,
    val heatindexF: Double?,
    val dewpointC: Double?,
    val dewpointF: Double?,
    val visKm: Double?,
    val visMiles: Double?,
    val uv: Double?,
    val gustMph: Double?,
    val gustKph: Double?,
    val airQuality: AirQuality?,
)

data class Condition(
    val text: String?,
    val icon: String?,
    val code: Int?,
)

data class AirQuality(
    val co: Double?,
    val no2: Double?,
    val o3: Double?,
    val so2: Double?,
    val pm25: Double?,
    val pm10: Double?,
    val usEpaIndex: Int?,
    val gbDefraIndex: Int?,
)

data class Forecast(
    val forecastday: List<Forecastday>?,
)

data class Forecastday(
    val date: String?,
    val dateEpoch: Int?,
    val day: Day?,
    val astro: Astro?,
    val hour: List<Hour>?,
)

data class Day(
    val maxtempC: Double?,
    val maxtempF: Double?,
    val mintempC: Double?,
    val mintempF: Double?,
    val avgtempC: Double?,
    val avgtempF: Double?,
    val maxwindMph: Double?,
    val maxwindKph: Double?,
    val totalprecipMm: Double?,
    val totalprecipIn: Double?,
    val totalsnowCm: Double?,
    val avgvisKm: Double?,
    val avgvisMiles: Double?,
    val avghumidity: Int?,
    val dailyWillItRain: Int?,
    val dailyChanceOfRain: Int?,
    val dailyWillItSnow: Int?,
    val dailyChanceOfSnow: Int?,
    val condition: Condition2?,
    val uv: Double?,
)

data class Condition2(
    val text: String?,
    val icon: String?,
    val code: Int?,
)

data class Astro(
    val sunrise: String?,
    val sunset: String?,
    val moonrise: String?,
    val moonset: String?,
    val moonPhase: String?,
    val moonIllumination: Int?,
    val isMoonUp: Int?,
    val isSunUp: Int?,
)

data class Hour(
    val timeEpoch: Int?,
    val time: String?,
    val tempC: Double?,
    val tempF: Double?,
    val isDay: Int?,
    val condition: Condition3?,
    val windMph: Double?,
    val windKph: Double?,
    val windDegree: Int?,
    val windDir: String?,
    val pressureMb: Double?,
    val pressureIn: Double?,
    val precipMm: Double?,
    val precipIn: Double?,
    val snowCm: Double?,
    val humidity: Int?,
    val cloud: Int?,
    val feelslikeC: Double?,
    val feelslikeF: Double?,
    val windchillC: Double?,
    val windchillF: Double?,
    val heatindexC: Double?,
    val heatindexF: Double?,
    val dewpointC: Double?,
    val dewpointF: Double?,
    val willItRain: Int?,
    val chanceOfRain: Int?,
    val willItSnow: Int?,
    val chanceOfSnow: Int?,
    val visKm: Double?,
    val visMiles: Double?,
    val gustMph: Double?,
    val gustKph: Double?,
    val uv: Double?,
)

data class Condition3(
    val text: String?,
    val icon: String?,
    val code: Int?,
)
