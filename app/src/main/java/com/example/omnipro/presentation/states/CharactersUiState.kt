package com.example.omnipro.presentation.states

import com.example.omnipro.domain.data.CharacterModel

sealed interface CharactersUiState {
    data object Loading : CharactersUiState
    data class Success(val characters: List<CharacterModel>) : CharactersUiState
    data class Error(val messageStringResource: Int) : CharactersUiState
}