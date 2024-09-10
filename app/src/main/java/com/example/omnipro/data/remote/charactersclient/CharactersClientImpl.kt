package com.example.omnipro.data.remote.charactersclient

import com.apollographql.apollo.ApolloClient
import com.example.CharactersQuery
import com.example.omnipro.data.remote.data.CharacterResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CharactersClientImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : CharactersClient {
    override suspend fun getCharactersClient(): Flow<List<CharacterResponse>> {
        return apolloClient
            .query(CharactersQuery())
            .toFlow().map {
                listOf(CharacterResponse())
        }.catch {

        }
    }
}