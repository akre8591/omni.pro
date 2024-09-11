package com.example.omnipro.presentation.characterlist.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.omnipro.R
import com.example.omnipro.domain.data.CharacterModel
import com.example.omnipro.presentation.navigation.NavRoutes
import com.example.omnipro.presentation.theme.DIMEN_240
import com.example.omnipro.presentation.theme.DIMEN_4
import com.example.omnipro.presentation.theme.DIMEN_8
import com.example.omnipro.presentation.theme.LocalFont

@Composable
fun CharacterItemComponent(
    characterModel: CharacterModel,
    navigateTo: (String) -> Unit
) {
    Card(
        onClick = {
            navigateTo("${NavRoutes.CharacterDetails.path}/${characterModel.id}")
        },
        elevation = CardDefaults.cardElevation(),
        border = BorderStroke(0.05.dp, Color.White),
        shape = RoundedCornerShape(DIMEN_8),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(DIMEN_240),
            model = characterModel.image,
            error = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(bottomEnd = DIMEN_8, bottomStart = DIMEN_8))
                .background(color = Color.DarkGray),
        ) {
            Column(modifier = Modifier.padding(vertical = DIMEN_4, horizontal = DIMEN_4)) {
                Text(
                    text = stringResource(R.string.character_name, characterModel.name),
                    style = TextStyle(
                        fontStyle = FontStyle.Normal,
                        fontFamily = LocalFont.current.semiBold,
                        color = Color.White
                    )
                )
                Text(
                    text = stringResource(R.string.character_status, characterModel.status),
                    style = TextStyle(
                        fontStyle = FontStyle.Normal,
                        fontFamily = LocalFont.current.semiBold,
                        color = Color.White
                    )
                )
                Text(
                    text = stringResource(R.string.character_specie, characterModel.species),
                    style = TextStyle(
                        fontStyle = FontStyle.Normal,
                        fontFamily = LocalFont.current.semiBold,
                        color = Color.White
                    )
                )
            }
        }
    }
}
