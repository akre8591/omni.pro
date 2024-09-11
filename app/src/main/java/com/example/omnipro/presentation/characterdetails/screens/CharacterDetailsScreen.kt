package com.example.omnipro.presentation.characterdetails.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.omnipro.presentation.characterdetails.components.CharacterDetailsComponent
import com.example.omnipro.presentation.characterdetails.states.CharacterDetailsUiState
import com.example.omnipro.presentation.characterdetails.viewmodel.CharacterDetailsViewModel
import com.example.omnipro.presentation.common.components.ErrorComponent
import com.example.omnipro.presentation.common.components.LoadingComponent

@Composable
fun CharacterDetailsRoute(
    characterDetailsViewModel: CharacterDetailsViewModel = hiltViewModel()
) {
    val uiState by characterDetailsViewModel.uiState.collectAsStateWithLifecycle()

    CharacterDetailsScreen(
        uiState = uiState
    )
}

@Composable
fun CharacterDetailsScreen(
    uiState: CharacterDetailsUiState
) {
    when (uiState) {
        is CharacterDetailsUiState.Loading -> {
            LoadingComponent()
        }

        is CharacterDetailsUiState.Success -> {
            CharacterDetailsComponent(uiState.characterDetails)
        }

        is CharacterDetailsUiState.Error -> {
            ErrorComponent(errorMessage = stringResource(uiState.messageStringResource))
        }
    }
}
