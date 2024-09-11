package com.example.omnipro.presentation.characterdetails.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.omnipro.presentation.characterdetails.viewmodel.CharacterDetailsViewModel

@Composable
fun CharacterDetailsRoute(
    characterDetailsViewModel: CharacterDetailsViewModel = hiltViewModel()
) {
    CharacterDetailsScreen()
}

@Composable
fun CharacterDetailsScreen(

) {
    Text(text = "Details")
}
