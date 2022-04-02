package com.project.earthquake.dto

data class EarthquakeDto @JvmOverloads constructor(
        val country: String,
        val place: String,
        val magnitude: Double,
        val earthquakeTime: String,
)

