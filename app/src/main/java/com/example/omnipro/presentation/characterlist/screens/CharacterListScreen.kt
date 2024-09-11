package com.example.omnipro.presentation.characterlist.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.omnipro.presentation.characterlist.viewmodel.CharacterListViewModel
import com.example.omnipro.presentation.states.CharactersUiState

@Composable
fun CharacterListRoute(
    characterListViewModel: CharacterListViewModel = hiltViewModel(),
    navigateTo: (String) -> Unit
) {
    val uiState by characterListViewModel.uiState.collectAsStateWithLifecycle()
    CharacterListScreen(
        uiState = uiState,
        navigateTo = navigateTo
    )
}

@Composable
fun CharacterListScreen(
    uiState: CharactersUiState,
    navigateTo: (String) -> Unit
) {

}