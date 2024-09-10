package com.example.omnipro.domain.usecases

import com.example.omnipro.data.repository.CharactersRepository
import com.example.omnipro.data.repository.DataState
import com.example.omnipro.ui.states.CharactersUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke(page: Int): Flow<CharactersUiState> =
        charactersRepository.getCharacters(page = page).map { characters ->
            when (characters) {
                is DataState.Success -> CharactersUiState.Success(characters = characters.data)
                is DataState.Loading -> CharactersUiState.Loading
                is DataState.Error -> CharactersUiState.Error(message = characters.errorMessage)
            }
        }
}