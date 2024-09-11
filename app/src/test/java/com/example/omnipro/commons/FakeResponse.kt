package com.example.omnipro.commons

import com.example.omnipro.data.local.entities.toDomain
import com.example.omnipro.data.remote.data.CharacterResponse
import com.example.omnipro.data.remote.data.LocationResponse
import com.example.omnipro.data.remote.data.OriginResponse
import com.example.omnipro.data.remote.data.toCache

val characterListResponse = listOf(
    CharacterResponse(
        id = "1",
        name = "Rick",
        species = "Human",
        status = "Alive",
        origin = OriginResponse(name = "Earth"),
        location = LocationResponse(name = "Earth"),
        image = "http://fake-url.com"
    ),
    CharacterResponse(
        id = "2",
        name = "Morty",
        species = "Human",
        status = "Alive",
        origin = OriginResponse(name = "Earth"),
        location = LocationResponse(name = "Earth"),
        image = "http://fake-url.com"
    )
)

val characterListEntity = characterListResponse.toCache()

val characterListModel = characterListEntity.toDomain()
