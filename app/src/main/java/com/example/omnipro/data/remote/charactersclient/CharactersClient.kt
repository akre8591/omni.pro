package com.example.omnipro.data.remote.charactersclient

import com.example.omnipro.data.remote.data.CharacterResponse
import com.example.omnipro.data.remote.data.ResultNetwork

interface CharactersClient {
    suspend fun getCharactersClient(page: Int): ResultNetwork<List<CharacterResponse>>
}