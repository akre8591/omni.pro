package com.example.omnipro.presentation.navigation

sealed class NavRoutes(val path: String) {
    data object CharacterList : NavRoutes("character_list")
    data object CharacterDetails : NavRoutes("character_details")
}