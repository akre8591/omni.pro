package com.example.omnipro.presentation.characterlist.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.omnipro.presentation.characterlist.components.CharacterItemComponent
import com.example.omnipro.presentation.characterlist.states.CharacterListUiState
import com.example.omnipro.presentation.characterlist.viewmodel.CharacterListViewModel
import com.example.omnipro.presentation.common.components.ErrorComponent
import com.example.omnipro.presentation.common.components.LoadingComponent
import com.example.omnipro.presentation.theme.DIMEN_16
import com.example.omnipro.presentation.theme.DIMEN_24

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

@OptIn(ExperimentalMaterialApi::class)
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
            val state =
                rememberPullRefreshState(isRefreshing, onRefresh = { onRefresh(!actionToRefresh) })
            Box(modifier = Modifier.pullRefresh(state = state)) {
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
                PullRefreshIndicator(
                    refreshing = isRefreshing,
                    state = state,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
        }

        is CharacterListUiState.Error -> {
            ErrorComponent(errorMessage = stringResource(uiState.messageStringResource))
        }
    }
}
