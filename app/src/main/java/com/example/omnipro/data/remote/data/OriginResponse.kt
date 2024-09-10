package com.example.omnipro.data.remote.data

import com.example.CharactersQuery

data class OriginResponse(
    val name: String = ""
)

fun CharactersQuery.Origin?.toOriginResponse(): OriginResponse {
    return this?.let {
        OriginResponse(name = it.name.orEmpty())
    } ?: run { OriginResponse() }
}
