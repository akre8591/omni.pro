package com.example.omnipro.data.local.entities

import com.example.omnipro.domain.data.LocationModel

data class LocationCacheModel(
    val locationName: String = ""
) {
    fun toDomain(): LocationModel = LocationModel(name = locationName)
}
