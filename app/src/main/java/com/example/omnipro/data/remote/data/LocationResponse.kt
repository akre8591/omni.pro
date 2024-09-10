package com.example.omnipro.data.remote.data

import com.example.CharactersQuery
import com.example.omnipro.data.local.entities.LocationCacheModel

data class LocationResponse(
    val name: String = "",
) {
    fun toCache() = LocationCacheModel(locationName = name)
}

fun CharactersQuery.Location?.toLocationResponse(): LocationResponse {
    return this?.let {
        LocationResponse(name = it.name.orEmpty())
    } ?: run { LocationResponse() }
}