package com.example.omnipro.presentation.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.omnipro.presentation.utils.Constants.ERROR_COMPONENT

@Composable
fun ErrorComponent(errorMessage: String) {
    Box(
        modifier = Modifier
            .testTag(ERROR_COMPONENT)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = errorMessage)
    }
}