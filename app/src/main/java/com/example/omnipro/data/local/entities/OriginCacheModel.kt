package com.example.omnipro.data.local.entities

import com.example.omnipro.domain.data.OriginModel

data class OriginCacheModel(
    val originName: String = ""
) {
    fun toDomain(): OriginModel = OriginModel(name = originName)
}