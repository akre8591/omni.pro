package com.example.omnipro.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.omnipro.domain.data.CharacterModel

@Entity(tableName = "Character")
data class CharacterEntity(
    @PrimaryKey
    val id: String = "",
    @ColumnInfo
    val name: String = "",
    @ColumnInfo
    val status: String = "",
    @ColumnInfo
    val species: String = "",
    @Embedded
    val origin: OriginCacheModel? = OriginCacheModel(),
    @Embedded
    val location: LocationCacheModel? = LocationCacheModel(),
    @ColumnInfo
    val image: String = "",
) {
    fun toDomain(): CharacterModel = CharacterModel(
        id = id,
        name = name,
        status = status,
        species = species,
        origin = origin?.toDomain(),
        location = location?.toDomain(),
        image = image
    )
}

fun List<CharacterEntity>.toDomain(): List<CharacterModel> {
    return this.map(CharacterEntity::toDomain)
}
