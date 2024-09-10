package com.example.omnipro.domain.data

import com.example.omnipro.data.remote.data.CharacterResponse

data class CharacterModel(
    val id: String = "",
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val origin: OriginModel? = OriginModel(),
    val location: LocationModel? = LocationModel(),
    val image: String = "",
)

fun List<CharacterResponse>.toDomain(): List<CharacterModel> {
    return this.map(CharacterResponse::toDomain)
}