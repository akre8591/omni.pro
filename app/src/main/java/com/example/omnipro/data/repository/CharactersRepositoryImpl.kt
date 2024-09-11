package com.example.omnipro.data.repository

import com.example.omnipro.data.local.dao.CharactersDao
import com.example.omnipro.data.local.entities.toDomain
import com.example.omnipro.data.remote.charactersclient.CharactersClient
import com.example.omnipro.data.remote.data.AppErrors
import com.example.omnipro.data.remote.data.ResultNetwork
import com.example.omnipro.data.remote.data.toCache
import com.example.omnipro.data.utils.AppDispatcher
import com.example.omnipro.data.utils.NetworkApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val charactersClient: CharactersClient,
    private val charactersDao: CharactersDao,
    private val networkApi: NetworkApi,
    private val dispatcher: AppDispatcher
) : CharactersRepository {

    override fun getCharacters(page: Int) = flow {
        if (networkApi.isNetworkAvailable()) {
            when (val response = charactersClient.getCharactersClient(page = page)) {
                is ResultNetwork.Success -> {
                    charactersDao.insertCharacters(response.data.toCache())
                }

                is ResultNetwork.FetchError -> {
                    emit(DataState.Error(response.error))
                }

                is ResultNetwork.GraphqlError -> {
                    emit(DataState.Error(response.error))
                }
            }
        }
        val localData = charactersDao.getLocalCharacters().firstOrNull()
        if (!localData.isNullOrEmpty()) {
            emit(DataState.Success(localData.toDomain()))
        } else {
            emit(DataState.Error(AppErrors.NO_CACHE_DATA))
        }
    }.onStart {
        emit(DataState.Loading)
    }.catch {
        emit(DataState.Error(AppErrors.UNKNOWN_ERROR))
    }.flowOn(dispatcher.io())

    override fun getCharacterById(id: String) = flow {
        val character = charactersDao.getCharacterById(id = id).firstOrNull()
        if (character != null) {
            emit(DataState.Success(character.toDomain()))
        } else {
            emit(DataState.Error(AppErrors.NO_CACHE_DATA))
        }
    }.onStart {
        DataState.Loading
    }.catch {
        emit(DataState.Error(AppErrors.UNKNOWN_ERROR))
    }.flowOn(dispatcher.io())
}
