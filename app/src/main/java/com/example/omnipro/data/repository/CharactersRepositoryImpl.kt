package com.example.omnipro.data.repository

import com.example.omnipro.data.local.dao.CharactersDao
import com.example.omnipro.data.local.entities.toDomain
import com.example.omnipro.data.remote.charactersclient.CharactersClient
import com.example.omnipro.data.remote.data.ResultNetwork
import com.example.omnipro.data.remote.data.toCache
import com.example.omnipro.data.utils.AppDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val charactersClient: CharactersClient,
    private val charactersDao: CharactersDao,
    private val dispatcher: AppDispatcher
) : CharactersRepository {

    override fun getCharacters(page: Int) = flow {
        when (val response = charactersClient.getCharactersClient(page = page)) {
            is ResultNetwork.Success -> {
                charactersDao.insertCharacters(response.data.toCache())
                val localData = charactersDao.getLocalCharacters().firstOrNull()
                if (!localData.isNullOrEmpty()) {
                    emit(DataState.Success(localData.toDomain()))
                } else {
                    emit(DataState.Error(""))
                }
            }

            is ResultNetwork.FetchError -> {
                emit(DataState.Error(""))
            }

            is ResultNetwork.GraphqlError -> {
                emit(DataState.Error(""))
            }
        }
    }.onStart {
        emit(DataState.Loading)
    }.catch {
        emit(DataState.Error(it.message.orEmpty()))
    }.flowOn(dispatcher.io())
}