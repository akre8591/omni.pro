package com.example.omnipro.fakeclasses

import com.example.omnipro.data.remote.charactersclient.CharactersClient
import com.example.omnipro.data.remote.data.CharacterResponse
import com.example.omnipro.data.remote.data.ResultNetwork

class FakeCharactersClient : CharactersClient {

    var charactersResponse: ResultNetwork<List<CharacterResponse>>? = null

    override suspend fun getCharactersClient(page: Int): ResultNetwork<List<CharacterResponse>> {
        return charactersResponse ?: throw Exception()
    }
}