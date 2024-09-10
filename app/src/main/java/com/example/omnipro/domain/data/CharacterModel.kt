package com.example.omnipro.domain.data

data class CharacterModel(
    val id: String = "",
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val origin: OriginModel? = OriginModel(),
    val location: LocationModel? = LocationModel(),
    val image: String = "",
)
