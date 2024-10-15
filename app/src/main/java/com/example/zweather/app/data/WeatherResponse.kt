package com.example.zweather.app.data

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class WeatherResponse @JsonCreator constructor(
    @JsonProperty("location") val location: Location? = null,
    @JsonProperty("current") val current: Current? = null,
    @JsonProperty("forecast") val forecast: Forecast? = null,
)

data class Location @JsonCreator constructor(
    @JsonProperty("name") val name: String?,
    @JsonProperty("region") val region: String?,
    @JsonProperty("country") val country: String?,
    @JsonProperty("lat") val lat: Double?,
    @JsonProperty("lon") val lon: Double?,
    @JsonProperty("tz_id") val tzId: String?,
    @JsonProperty("localtime_epoch") val localtimeEpoch: Int?,
    @JsonProperty("localtime") val localtime: String?,
)

data class Current @JsonCreator constructor(
    @JsonProperty("last_updated_epoch") val lastUpdatedEpoch: Int?,
    @JsonProperty("last_updated") val lastUpdated: String?,
    @JsonProperty("temp_c") val tempC: Double?,
    @JsonProperty("temp_f") val tempF: Double?,
    @JsonProperty("is_day") val isDay: Int?,
    @JsonProperty("condition") val condition: Condition?,
    @JsonProperty("wind_mph") val windMph: Double?,
    @JsonProperty("wind_kph") val windKph: Double?,
    @JsonProperty("wind_degree") val windDegree: Int?,
    @JsonProperty("wind_dir") val windDir: String?,
    @JsonProperty("pressure_mb") val pressureMb: Double?,
    @JsonProperty("pressure_in") val pressureIn: Double?,
    @JsonProperty("precip_mm") val precipMm: Double?,
    @JsonProperty("precip_in") val precipIn: Double?,
    @JsonProperty("humidity") val humidity: Int?,
    @JsonProperty("cloud") val cloud: Int?,
    @JsonProperty("feelslike_c") val feelslikeC: Double?,
    @JsonProperty("feelslike_f") val feelslikeF: Double?,
    @JsonProperty("windchill_c") val windchillC: Double?,
    @JsonProperty("windchill_f") val windchillF: Double?,
    @JsonProperty("heatindex_c") val heatindexC: Double?,
    @JsonProperty("heatindex_f") val heatindexF: Double?,
    @JsonProperty("dewpoint_c") val dewpointC: Double?,
    @JsonProperty("dewpoint_f") val dewpointF: Double?,
    @JsonProperty("vis_km") val visKm: Double?,
    @JsonProperty("vis_miles") val visMiles: Double?,
    @JsonProperty("uv") val uv: Double?,
    @JsonProperty("gust_mph") val gustMph: Double?,
    @JsonProperty("gust_kph") val gustKph: Double?,
    @JsonProperty("air_quality") val airQuality: AirQuality?,
)

data class Condition @JsonCreator constructor(
    @JsonProperty("text") val text: String?,
    @JsonProperty("icon") val icon: String?,
    @JsonProperty("code") val code: Int?,
)

data class AirQuality @JsonCreator constructor(
    @JsonProperty("co") val co: Double?,
    @JsonProperty("no2") val no2: Double?,
    @JsonProperty("o3") val o3: Double?,
    @JsonProperty("so2") val so2: Double?,
    @JsonProperty("pm2_5") val pm25: Double?,
    @JsonProperty("pm10") val pm10: Double?,
    @JsonProperty("us-epa-index") val usEpaIndex: Int?,
    @JsonProperty("gb-defra-index") val gbDefraIndex: Int?,
)

data class Forecast @JsonCreator constructor(
    @JsonProperty("forecastday") val forecastday: List<Forecastday>,
)

data class Forecastday @JsonCreator constructor(
    @JsonProperty("date") val date: String?,
    @JsonProperty("date_epoch") val dateEpoch: Int?,
    @JsonProperty("day") val day: Day,
    @JsonProperty("astro") val astro: Astro,
    @JsonProperty("hour") val hour: List<Hour>,
)

data class Day @JsonCreator constructor(
    @JsonProperty("maxtemp_c") val maxtempC: Double?,
    @JsonProperty("maxtemp_f") val maxtempF: Double?,
    @JsonProperty("mintemp_c") val mintempC: Double?,
    @JsonProperty("mintemp_f") val mintempF: Double?,
    @JsonProperty("avgtemp_c") val avgtempC: Double?,
    @JsonProperty("avgtemp_f") val avgtempF: Double?,
    @JsonProperty("maxwind_mph") val maxwindMph: Double?,
    @JsonProperty("maxwind_kph") val maxwindKph: Double?,
    @JsonProperty("totalprecip_mm") val totalprecipMm: Double?,
    @JsonProperty("totalprecip_in") val totalprecipIn: Double?,
    @JsonProperty("totalsnow_cm") val totalsnowCm: Double?,
    @JsonProperty("avgvis_km") val avgvisKm: Double?,
    @JsonProperty("avgvis_miles") val avgvisMiles: Double?,
    @JsonProperty("avghumidity") val avghumidity: Int?,
    @JsonProperty("daily_will_it_rain") val dailyWillItRain: Int?,
    @JsonProperty("daily_chance_of_rain") val dailyChanceOfRain: Int?,
    @JsonProperty("daily_will_it_snow") val dailyWillItSnow: Int?,
    @JsonProperty("daily_chance_of_snow") val dailyChanceOfSnow: Int?,
    @JsonProperty("condition") val condition: Condition2?,
    @JsonProperty("uv") val uv: Double?,
)

data class Condition2 @JsonCreator constructor(
    @JsonProperty("text") val text: String?,
    @JsonProperty("icon") val icon: String?,
    @JsonProperty("code") val code: Int?,
)

data class Astro @JsonCreator constructor(
    @JsonProperty("sunrise") val sunrise: String?,
    @JsonProperty("sunset") val sunset: String?,
    @JsonProperty("moonrise") val moonrise: String?,
    @JsonProperty("moonset") val moonset: String?,
    @JsonProperty("moon_phase") val moonPhase: String?,
    @JsonProperty("moon_illumination") val moonIllumination: Int?,
    @JsonProperty("is_moon_up") val isMoonUp: Int?,
    @JsonProperty("is_sun_up") val isSunUp: Int?,
)

data class Hour @JsonCreator constructor(
    @JsonProperty("time_epoch") val timeEpoch: Int?,
    @JsonProperty("time") val time: String?,
    @JsonProperty("temp_c") val tempC: Double?,
    @JsonProperty("temp_f") val tempF: Double?,
    @JsonProperty("is_day") val isDay: Int?,
    @JsonProperty("condition") val condition: Condition3?,
    @JsonProperty("wind_mph") val windMph: Double?,
    @JsonProperty("wind_kph") val windKph: Double?,
    @JsonProperty("wind_degree") val windDegree: Int?,
    @JsonProperty("wind_dir") val windDir: String?,
    @JsonProperty("pressure_mb") val pressureMb: Double?,
    @JsonProperty("pressure_in") val pressureIn: Double?,
    @JsonProperty("precip_mm") val precipMm: Double?,
    @JsonProperty("precip_in") val precipIn: Double?,
    @JsonProperty("snow_cm") val snowCm: Double?,
    @JsonProperty("humidity") val humidity: Int?,
    @JsonProperty("cloud") val cloud: Int?,
    @JsonProperty("feelslike_c") val feelslikeC: Double?,
    @JsonProperty("feelslike_f") val feelslikeF: Double?,
    @JsonProperty("windchill_c") val windchillC: Double?,
    @JsonProperty("windchill_f") val windchillF: Double?,
    @JsonProperty("heatindex_c") val heatindexC: Double?,
    @JsonProperty("heatindex_f") val heatindexF: Double?,
    @JsonProperty("dewpoint_c") val dewpointC: Double?,
    @JsonProperty("dewpoint_f") val dewpointF: Double?,
    @JsonProperty("will_it_rain") val willItRain: Int?,
    @JsonProperty("chance_of_rain") val chanceOfRain: Int?,
    @JsonProperty("will_it_snow") val willItSnow: Int?,
    @JsonProperty("chance_of_snow") val chanceOfSnow: Int?,
    @JsonProperty("vis_km") val visKm: Double?,
    @JsonProperty("vis_miles") val visMiles: Double?,
    @JsonProperty("gust_mph") val gustMph: Double?,
    @JsonProperty("gust_kph") val gustKph: Double?,
    @JsonProperty("uv") val uv: Double?,
)

data class Condition3 @JsonCreator constructor(
    @JsonProperty("text") val text: String?,
    @JsonProperty("icon") val icon: String?,
    @JsonProperty("code") val code: Int?,
)
