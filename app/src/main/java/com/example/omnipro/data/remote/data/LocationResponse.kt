package com.example.omnipro.data.remote.data

data class LocationResponse(
    val id: Int = 0,
    val name: String = "",
    val type: String = "",
    val dimension: String = "",
    val created: String = "",
    val residents: List<CharacterResponse> = emptyList()
)
