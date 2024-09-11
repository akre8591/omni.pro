package com.example.omnipro.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.omnipro.presentation.theme.DIMEN_0_5

@Composable
fun AppDivider(
    modifier: Modifier = Modifier,
    color: Color = Color.DarkGray,
    height: Dp = DIMEN_0_5
) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .background(color = color)
    )
}