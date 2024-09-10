package com.example.omnipro.data.remote.data

import com.example.CharactersQuery

data class LocationResponse(
    val name: String = "",
)

fun CharactersQuery.Location?.toLocationResponse(): LocationResponse {
    return this?.let {
        LocationResponse(name = it.name.orEmpty())
    } ?: run { LocationResponse() }
}