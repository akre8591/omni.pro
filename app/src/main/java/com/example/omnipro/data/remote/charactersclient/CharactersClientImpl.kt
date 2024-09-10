package com.example.omnipro.data.remote.charactersclient

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Optional
import com.example.CharactersQuery
import com.example.omnipro.data.remote.data.CharacterResponse
import com.example.omnipro.data.remote.data.AppErrors
import com.example.omnipro.data.remote.data.ResultNetwork
import com.example.omnipro.data.remote.data.toResponse
import com.example.omnipro.data.utils.AppDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersClientImpl @Inject constructor(
    private val apolloClient: ApolloClient,
    private val dispatcher: AppDispatcher
) : CharactersClient {
    override suspend fun getCharactersClient(page: Int): ResultNetwork<List<CharacterResponse>> =
        withContext(dispatcher.io()) {
            val response = apolloClient.query(CharactersQuery(Optional.present(page))).execute()
            if (response.data != null) {
                val results = response.data?.characters?.results.toResponse()
                return@withContext ResultNetwork.Success(results)
            } else {
                return@withContext if (response.exception != null) {
                    ResultNetwork.FetchError(AppErrors.COMMUNICATION_SERVER_ERROR)
                } else {
                    return@withContext ResultNetwork.GraphqlError(AppErrors.UNABLE_COMPLETELY_PROCESS_QUERY)
                }
            }
        }
}