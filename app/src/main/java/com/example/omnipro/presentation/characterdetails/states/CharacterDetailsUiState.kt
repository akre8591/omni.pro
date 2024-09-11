package com.example.omnipro.presentation.characterdetails.states

import com.example.omnipro.domain.data.CharacterModel

sealed interface CharacterDetailsUiState {
    data object Loading : CharacterDetailsUiState
    data class Success(val characterDetails: CharacterModel) : CharacterDetailsUiState
    data class Error(val messageStringResource: Int) : CharacterDetailsUiState
}
