package com.example.omnipro.data.remote.data

data class CharacterResponse(
    val id: Int = 0,
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    val origin: LocationResponse = LocationResponse(),
    val location: LocationResponse = LocationResponse(),
    val image: String = "",
    val episode: List<EpisodeResponse> = emptyList(),
    val created: String = ""
)
