package com.example.omnipro.data.remote.data

data class EpisodeResponse(
    val id: Int = 0,
    val name: String = "",
    val airDate: String = "",
    val episode: String = "",
    val characters: List<CharacterResponse> = emptyList(),
    val created: String = ""
)
