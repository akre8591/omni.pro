package com.example.omnipro.presentation.characterdetails.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import com.example.omnipro.R
import com.example.omnipro.domain.data.CharacterModel
import com.example.omnipro.presentation.common.components.AppDivider
import com.example.omnipro.presentation.theme.DIMEN_12
import com.example.omnipro.presentation.theme.DIMEN_16
import com.example.omnipro.presentation.theme.DIMEN_24
import com.example.omnipro.presentation.theme.DIMEN_240
import com.example.omnipro.presentation.theme.DIMEN_32
import com.example.omnipro.presentation.theme.DIMEN_4
import com.example.omnipro.presentation.theme.GORDILOCK_PLUS
import com.example.omnipro.presentation.theme.LocalFont
import com.example.omnipro.presentation.theme.TEXT_PAPA_BEAR

@Composable
fun CharacterDetailsComponent(characterModel: CharacterModel) {

    Column(
        Modifier
            .padding(vertical = DIMEN_32, horizontal = DIMEN_24)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = characterModel.image,
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(DIMEN_240)
                .clip(CircleShape)
        )

        Text(
            text = characterModel.name,
            modifier = Modifier
                .padding(top = DIMEN_12),
            style = TextStyle(
                fontStyle = FontStyle.Normal,
                fontFamily = LocalFont.current.bold,
                fontSize = GORDILOCK_PLUS
            )
        )

        Text(
            text = characterModel.species,
            Modifier
                .padding(top = DIMEN_4),
            style = TextStyle(
                fontStyle = FontStyle.Normal,
                fontFamily = LocalFont.current.semiBold,
                fontSize = TEXT_PAPA_BEAR
            )
        )

        Text(
            text = stringResource(R.string.character_status, characterModel.status),
            Modifier
                .fillMaxWidth()
                .padding(top = DIMEN_32),
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontStyle = FontStyle.Normal,
                fontFamily = LocalFont.current.semiBold,
                fontSize = TEXT_PAPA_BEAR
            )
        )
        AppDivider(modifier = Modifier.padding(top = DIMEN_16))

        Text(
            text = stringResource(R.string.origin, characterModel.origin?.name.orEmpty()),
            Modifier
                .fillMaxWidth()
                .padding(top = DIMEN_16),
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontStyle = FontStyle.Normal,
                fontFamily = LocalFont.current.semiBold,
                fontSize = TEXT_PAPA_BEAR
            )
        )
        AppDivider(modifier = Modifier.padding(top = DIMEN_16))

        Text(
            text = stringResource(R.string.location, characterModel.location?.name.orEmpty()),
            Modifier
                .fillMaxWidth()
                .padding(top = DIMEN_16),
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontStyle = FontStyle.Normal,
                fontFamily = LocalFont.current.semiBold,
                fontSize = TEXT_PAPA_BEAR
            )
        )
        AppDivider(modifier = Modifier.padding(top = DIMEN_16))
    }
}