package com.example.omnipro.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.omnipro.data.local.dao.CharactersDao
import com.example.omnipro.data.local.entities.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = false
)
abstract class OmniProDatabase : RoomDatabase() {

    abstract fun charactersDao(): CharactersDao
}