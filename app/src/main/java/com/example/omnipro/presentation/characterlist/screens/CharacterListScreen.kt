package com.example.omnipro.presentation.characterlist.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.omnipro.presentation.characterlist.components.CharacterItemComponent
import com.example.omnipro.presentation.characterlist.viewmodel.CharacterListViewModel
import com.example.omnipro.presentation.states.CharactersUiState
import com.example.omnipro.presentation.theme.DIMEN_16
import com.example.omnipro.presentation.theme.DIMEN_24

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
    when (uiState) {
        is CharactersUiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is CharactersUiState.Success -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(DIMEN_16),
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(
                    vertical = DIMEN_24,
                    horizontal = DIMEN_24
                )
            ) {
                items(uiState.characters) { character ->
                    CharacterItemComponent(
                        characterModel = character,
                        navigateTo = navigateTo
                    )
                }
            }
        }

        is CharactersUiState.Error -> {

        }
    }
}