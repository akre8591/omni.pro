package com.example.omnipro.data.remote.charactersclient

import com.example.omnipro.data.remote.data.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface CharactersClient {
    suspend fun getCharactersClient(): Flow<List<CharacterResponse>>
}