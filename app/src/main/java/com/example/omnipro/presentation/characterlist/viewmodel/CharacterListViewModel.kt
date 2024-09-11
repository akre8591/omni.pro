package com.example.omnipro.presentation.characterlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omnipro.domain.usecases.GetCharactersUseCase
import com.example.omnipro.presentation.characterlist.states.CharacterListUiState
import com.example.omnipro.presentation.characterlist.states.RefreshUiState
import com.example.omnipro.presentation.utils.Constants.INITIAL_PAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _refreshUiState: MutableStateFlow<RefreshUiState> =
        MutableStateFlow(RefreshUiState())
    val refreshUiState: StateFlow<RefreshUiState> = _refreshUiState.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class)
    val uiState: StateFlow<CharacterListUiState> = refreshUiState.flatMapLatest {
        stopRefreshing()
        getCharactersUseCase(page = INITIAL_PAGE)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = CharacterListUiState.Loading
    )

    fun onRefresh(refresh: Boolean) {
        _refreshUiState.update { refreshUiState ->
            refreshUiState.copy(isRefreshing = true, actionToRefresh = !refresh)
        }
    }

    private fun stopRefreshing() {
        _refreshUiState.update { refreshUiState ->
            refreshUiState.copy(isRefreshing = false)
        }
    }
}


