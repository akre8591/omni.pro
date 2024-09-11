package com.example.omnipro.presentation.characterdetails.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omnipro.domain.usecases.GetCharacterByIdUseCase
import com.example.omnipro.presentation.characterdetails.states.CharacterDetailsUiState
import com.example.omnipro.presentation.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val characterId: String? = savedStateHandle[Constants.CHARACTER_ID]

    val uiState: StateFlow<CharacterDetailsUiState> =
        getCharacterByIdUseCase(characterId.orEmpty()).stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = CharacterDetailsUiState.Loading
        )
}
