package com.example.omnipro.data.remote.data

import com.example.CharactersQuery
import com.example.omnipro.data.local.entities.OriginCacheModel

data class OriginResponse(
    val name: String = ""
) {
    fun toCache() = OriginCacheModel(originName = name)
}

fun CharactersQuery.Origin?.toOriginResponse(): OriginResponse {
    return this?.let {
        OriginResponse(name = it.name.orEmpty())
    } ?: run { OriginResponse() }
}
