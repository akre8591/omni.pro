package com.example.omnipro.presentation.characterlist.states

import com.example.omnipro.domain.data.CharacterModel

sealed interface CharacterListUiState {
    data object Loading : CharacterListUiState
    data class Success(val characters: List<CharacterModel>) : CharacterListUiState
    data class Error(val messageStringResource: Int) : CharacterListUiState
}