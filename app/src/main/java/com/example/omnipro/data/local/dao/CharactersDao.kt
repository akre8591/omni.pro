package com.example.omnipro.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.omnipro.data.local.entities.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacters(characters: List<CharacterEntity>)

    @Query("SELECT * FROM Character")
    fun getLocalCharacters(): Flow<List<CharacterEntity>>
}