package com.example.omnipro.domain.usecases

import com.example.omnipro.data.repository.CharactersRepository
import com.example.omnipro.data.repository.DataState
import com.example.omnipro.presentation.characterlist.states.CharacterListUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke(page: Int): Flow<CharacterListUiState> =
        charactersRepository.getCharacters(page = page).map { characters ->
            when (characters) {
                is DataState.Success -> CharacterListUiState.Success(characters = characters.data)
                is DataState.Loading -> CharacterListUiState.Loading
                is DataState.Error -> CharacterListUiState.Error(messageStringResource = characters.error.messageStringResource)
            }
        }
}
