package com.example.omnipro.data.repository

import com.example.omnipro.domain.data.CharacterModel
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters(page: Int): Flow<DataState<List<CharacterModel>>>
    fun getCharacterById(id: String): Flow<DataState<CharacterModel>>
}