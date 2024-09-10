package com.example.omnipro.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omnipro.domain.usecases.GetCharactersUseCase
import com.example.omnipro.presentation.states.CharactersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    val uiState: StateFlow<CharactersUiState> = getCharactersUseCase(page = 1).stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = CharactersUiState.Loading
    )
}
