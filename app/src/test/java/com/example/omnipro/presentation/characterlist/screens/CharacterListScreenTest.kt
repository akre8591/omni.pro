package com.example.omnipro.presentation.characterlist.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import com.example.omnipro.common.characterListModel
import com.example.omnipro.data.remote.data.AppErrors
import com.example.omnipro.presentation.characterlist.states.CharacterListUiState
import com.example.omnipro.presentation.theme.OmniProTheme
import com.example.omnipro.presentation.utils.Constants.LIST_COMPONENT
import com.example.omnipro.presentation.utils.Constants.LOADING_COMPONENT
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CharacterListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `list is displayed correctly`() {
        val uiState = CharacterListUiState.Success(characters = characterListModel)

        setContent(uiState, navigateTo = { })

        composeTestRule.onNodeWithTag(LIST_COMPONENT)
            .assertIsDisplayed()
    }

    @Test
    fun `loading component is displayed correctly`() {
        val uiState = CharacterListUiState.Loading

        setContent(uiState, navigateTo = { })

        composeTestRule.onNodeWithTag(LOADING_COMPONENT)
            .assertIsDisplayed()
    }

    @Test
    fun `error component is displayed correctly`() {
        val uiState = CharacterListUiState.Error(AppErrors.UNKNOWN_ERROR.messageStringResource)

        setContent(uiState, navigateTo = { })

        composeTestRule.onNodeWithText("Unknown error")
            .assertIsDisplayed()
    }

    @Test
    fun `onClick item works correctly`() {
        var itemHasBeenClicking = false
        val uiState = CharacterListUiState.Success(characters = characterListModel)

        setContent(uiState, navigateTo = {
            itemHasBeenClicking = true
        })

        composeTestRule.onNodeWithTag(LIST_COMPONENT)
            .performScrollToIndex(0)
            .performClick()

        assert(itemHasBeenClicking)
    }

    private fun setContent(
        uiState: CharacterListUiState,
        navigateTo: (String) -> Unit
    ) {
        composeTestRule.setContent {
            OmniProTheme {
                CharacterListScreen(
                    uiState = uiState,
                    navigateTo = navigateTo,
                    onRefresh = { },
                    isRefreshing = false,
                    actionToRefresh = false
                )
            }
        }
    }
}