package com.example.omnipro.data.remote.data

import com.example.CharactersQuery
import com.example.omnipro.domain.data.LocationModel

data class LocationResponse(
    val name: String = "",
) {
    fun toDomain() = LocationModel(name = name)
}

fun CharactersQuery.Location?.toLocationResponse(): LocationResponse {
    return this?.let {
        LocationResponse(name = it.name.orEmpty())
    } ?: run { LocationResponse() }
}