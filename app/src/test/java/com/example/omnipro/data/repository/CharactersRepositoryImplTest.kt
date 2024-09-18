package com.example.omnipro.data.repository

import app.cash.turbine.test
import com.example.omnipro.common.characterListEntity
import com.example.omnipro.common.characterListResponse
import com.example.omnipro.data.remote.data.AppErrors
import com.example.omnipro.data.remote.data.ResultNetwork
import com.example.omnipro.fakeclasses.FakeCharactersClient
import com.example.omnipro.fakeclasses.FakeCharactersDao
import com.example.omnipro.fakeclasses.FakeNetworkApi
import com.example.omnipro.utils.MainDispatcherRule
import com.example.omnipro.utils.TestDispatcherImpl
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CharactersRepositoryImplTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var sut: CharactersRepository
    private val charactersClient = FakeCharactersClient()
    private val charactersDao = FakeCharactersDao()
    private val networkApi = FakeNetworkApi()
    private val appDispatcher = TestDispatcherImpl()

    @Before
    fun setup() {
        sut = CharactersRepositoryImpl(
            charactersClient = charactersClient,
            charactersDao = charactersDao,
            networkApi = networkApi,
            dispatcher = appDispatcher,
        )
    }

    @Test
    fun `characters are saved when the network is available & response is success`() = runTest {
        networkApi.networkAvailable = true
        charactersClient.charactersResponse = ResultNetwork.Success(characterListResponse)
        sut.getCharacters(page = 1).test {
            assert(awaitItem() is DataState.Loading)
            assert(awaitItem() is DataState.Success)
            awaitComplete()
        }
    }

    @Test
    fun `characters are not saved because the response has a fetch error`() = runTest {
        networkApi.networkAvailable = true
        charactersClient.charactersResponse =
            ResultNetwork.FetchError(AppErrors.COMMUNICATION_SERVER_ERROR)
        sut.getCharacters(page = 1).test {
            assert(awaitItem() is DataState.Loading)
            assert(awaitItem() is DataState.Error)
            assert(awaitItem() is DataState.Error)
            awaitComplete()
        }
    }

    @Test
    fun `characters are not saved because the response has a graphql error`() = runTest {
        networkApi.networkAvailable = true
        charactersClient.charactersResponse =
            ResultNetwork.FetchError(AppErrors.UNABLE_COMPLETELY_PROCESS_QUERY)
        sut.getCharacters(page = 1).test {
            assert(awaitItem() is DataState.Loading)
            assert(awaitItem() is DataState.Error)
            assert(awaitItem() is DataState.Error)
            awaitComplete()
        }
    }

    @Test
    fun `characters are not saved because there is not internet avaiable`() = runTest {
        networkApi.networkAvailable = false
        sut.getCharacters(page = 1).test {
            assert(awaitItem() is DataState.Loading)
            assert(awaitItem() is DataState.Error)
            awaitComplete()
        }
    }

    @Test
    fun `function expose the cache data when there is not internet available`() = runTest {
        networkApi.networkAvailable = false
        charactersDao.insertCharacters(characterListEntity)
        sut.getCharacters(page = 1).test {
            assert(awaitItem() is DataState.Loading)
            assert(awaitItem() is DataState.Success)
            awaitComplete()
        }
    }

    @Test
    fun `getting characters catches an unexpected exception or error`() = runTest {
        networkApi.networkAvailable = true
        charactersClient.charactersResponse = null
        sut.getCharacters(page = 1).test {
            assert(awaitItem() is DataState.Loading)
            assert(awaitItem() is DataState.Error)
            awaitComplete()
        }
    }

    @Test
    fun `get character by id function successfully `() = runTest {
        charactersDao.insertCharacters(characterListEntity)
        sut.getCharacterById(id = "1").test {
            assert(awaitItem() is DataState.Success)
            awaitComplete()
        }
    }

    @Test
    fun `get character by id function was unsuccessful`() = runTest {
        sut.getCharacterById(id = "1").test {
            assert(awaitItem() is DataState.Error)
            awaitComplete()
        }
    }
}
