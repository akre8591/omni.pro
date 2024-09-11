package com.example.omnipro.domain.usecases

import com.example.omnipro.data.repository.CharactersRepository
import com.example.omnipro.data.repository.DataState
import com.example.omnipro.presentation.characterdetails.states.CharacterDetailsUiState
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke(id: String): Flow<CharacterDetailsUiState> =
        charactersRepository.getCharacterById(id = id).map { character ->
            when (character) {
                is DataState.Success -> CharacterDetailsUiState.Success(characterDetails = character.data)
                is DataState.Loading -> CharacterDetailsUiState.Loading
                is DataState.Error -> CharacterDetailsUiState.Error(messageStringResource = character.error.messageStringResource)
            }
        }
}