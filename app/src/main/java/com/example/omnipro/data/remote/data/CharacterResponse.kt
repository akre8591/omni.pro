package com.example.omnipro.data.remote.data

import com.example.CharactersQuery
import com.example.omnipro.data.local.entities.CharacterEntity

data class CharacterResponse(
    val id: String = "",
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val origin: OriginResponse? = OriginResponse(),
    val location: LocationResponse? = LocationResponse(),
    val image: String = "",
) {
    fun toCache() = CharacterEntity(
        id = id,
        name = name,
        status = status,
        species = species,
        origin = origin?.toCache(),
        location = location?.toCache(),
        image = image
    )
}

fun List<CharacterResponse>.toCache(): List<CharacterEntity> {
    return this.map(CharacterResponse::toCache)
}

fun List<CharactersQuery.Result?>?.toResponse(): List<CharacterResponse> {
    return this?.map { result ->
        CharacterResponse(
            id = result?.id.orEmpty(),
            name = result?.name.orEmpty(),
            status = result?.status.orEmpty(),
            species = result?.species.orEmpty(),
            origin = result?.origin?.toOriginResponse(),
            location = result?.location?.toLocationResponse(),
            image = result?.image.orEmpty(),
        )
    } ?: run {
        emptyList()
    }
}
