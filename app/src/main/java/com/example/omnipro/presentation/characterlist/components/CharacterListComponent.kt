package com.example.omnipro.presentation.characterlist.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.omnipro.domain.data.CharacterModel
import com.example.omnipro.presentation.theme.DIMEN_16
import com.example.omnipro.presentation.theme.DIMEN_24
import com.example.omnipro.presentation.utils.Constants.LIST_COMPONENT

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CharacterListComponent(
    characters: List<CharacterModel>,
    navigateTo: (String) -> Unit,
    onRefresh: (Boolean) -> Unit,
    isRefreshing: Boolean,
    actionToRefresh: Boolean
) {
    val state = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = { onRefresh(!actionToRefresh) })

    Box(modifier = Modifier.pullRefresh(state = state)) {
        LazyColumn(
            modifier = Modifier
                .testTag(LIST_COMPONENT)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(DIMEN_16),
            contentPadding = PaddingValues(
                vertical = DIMEN_24,
                horizontal = DIMEN_24
            )
        ) {
            items(characters) { character ->
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