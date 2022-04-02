package com.project.earthquake.dto.request

data class EarthquakeRequest @JvmOverloads constructor(
        val country: String,
        val countofDays: Integer
)