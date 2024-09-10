package com.example.omnipro.data.remote.data

import com.example.CharactersQuery
import com.example.omnipro.domain.data.OriginModel

data class OriginResponse(
    val name: String = ""
) {
    fun toDomain() = OriginModel(name = name)
}

fun CharactersQuery.Origin?.toOriginResponse(): OriginResponse {
    return this?.let {
        OriginResponse(name = it.name.orEmpty())
    } ?: run { OriginResponse() }
}
