package com.example.omnipro.presentation.characterlist.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.omnipro.presentation.characterlist.components.CharacterListComponent
import com.example.omnipro.presentation.characterlist.states.CharacterListUiState
import com.example.omnipro.presentation.characterlist.viewmodel.CharacterListViewModel
import com.example.omnipro.presentation.common.components.ErrorComponent
import com.example.omnipro.presentation.common.components.LoadingComponent

@Composable
fun CharacterListRoute(
    characterListViewModel: CharacterListViewModel = hiltViewModel(),
    navigateTo: (String) -> Unit
) {
    val uiState by characterListViewModel.uiState.collectAsStateWithLifecycle()
    val refreshUiState by characterListViewModel.refreshUiState.collectAsStateWithLifecycle()

    CharacterListScreen(
        uiState = uiState,
        navigateTo = navigateTo,
        onRefresh = characterListViewModel::onRefresh,
        isRefreshing = refreshUiState.isRefreshing,
        actionToRefresh = refreshUiState.actionToRefresh
    )
}

@Composable
fun CharacterListScreen(
    uiState: CharacterListUiState,
    navigateTo: (String) -> Unit,
    onRefresh: (Boolean) -> Unit,
    isRefreshing: Boolean,
    actionToRefresh: Boolean
) {
    when (uiState) {
        is CharacterListUiState.Loading -> {
            LoadingComponent()
        }

        is CharacterListUiState.Success -> {
            CharacterListComponent(
                characters = uiState.characters,
                navigateTo = navigateTo,
                onRefresh = onRefresh,
                isRefreshing = isRefreshing,
                actionToRefresh = actionToRefresh
            )
        }

        is CharacterListUiState.Error -> {
            ErrorComponent(errorMessage = stringResource(uiState.messageStringResource))
        }
    }
}
