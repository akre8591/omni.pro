package com.example.omnipro.domain.data

data class OriginModel(
    val name: String = ""
) {
    fun toDomain() = OriginModel(
        name = name
    )
}
