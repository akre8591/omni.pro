package com.example.omnipro.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.omnipro.presentation.characterdetails.screens.CharacterDetailsRoute
import com.example.omnipro.presentation.characterlist.screens.CharacterListRoute

@Composable
fun CharactersNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.CharacterList.path,
        modifier = modifier
    ) {
        composable(route = NavRoutes.CharacterList.path) {
            CharacterListRoute(navigateTo = navController::navigateTo)
        }
        composable(route = NavRoutes.CharacterDetails.path) {
            CharacterDetailsRoute()
        }
    }
}
