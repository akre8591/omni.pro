package com.example.omnipro.presentation.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

fun NavHostController.navigateTo(screenRoute: String) {
    navigate(screenRoute) {
        popUpTo(this@navigateTo.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavHostController.goBack() {
    popBackStack()
}