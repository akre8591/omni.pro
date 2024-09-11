package com.example.omnipro.fakeclasses

import com.example.omnipro.data.local.dao.CharactersDao
import com.example.omnipro.data.local.entities.CharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

class FakeCharactersDao : CharactersDao {
    private val inMemoryList = mutableListOf<CharacterEntity>()

    override fun insertCharacters(characters: List<CharacterEntity>) {
        inMemoryList.addAll(characters)
    }

    override fun getLocalCharacters(): Flow<List<CharacterEntity>> {
        return flowOf(inMemoryList)
    }

    override fun getCharacterById(id: String): Flow<CharacterEntity> {
        val characterDetails = inMemoryList.firstOrNull { it.id == id }
        return if (characterDetails != null) {
            flowOf(characterDetails)
        } else {
            emptyFlow()
        }
    }
}