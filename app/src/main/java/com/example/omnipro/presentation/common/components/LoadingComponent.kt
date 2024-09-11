package com.example.omnipro.presentation.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.omnipro.presentation.utils.Constants.LOADING_COMPONENT

@Composable
fun LoadingComponent() {
    Box(
        modifier = Modifier
            .testTag(LOADING_COMPONENT)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}