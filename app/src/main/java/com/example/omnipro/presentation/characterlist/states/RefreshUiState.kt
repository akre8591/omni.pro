package com.example.omnipro.presentation.characterlist.states

data class RefreshUiState(
    val isRefreshing: Boolean = false,
    val actionToRefresh: Boolean = false
)
