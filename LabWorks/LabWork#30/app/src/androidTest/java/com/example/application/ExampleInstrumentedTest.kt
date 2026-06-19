package com.example.application

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun login_withCorrectCredentials_showsSuccessMessage() {
        composeTestRule.onNodeWithTag("login_input")
            .performTextInput("admin")

        composeTestRule.onNodeWithTag("password_input")
            .performTextInput("admin")

        composeTestRule.onNodeWithTag("login_button")
            .performClick()

        composeTestRule.onNodeWithText("Успешная авторизация")
            .assertIsDisplayed()
    }

    @Test
    fun login_withWrongCredentials_showsFailureMessage() {
        composeTestRule.onNodeWithTag("login_input")
            .performTextInput("loch")

        composeTestRule.onNodeWithTag("password_input")
            .performTextInput("loch")

        composeTestRule.onNodeWithTag("login_button")
            .performClick()

        composeTestRule.onNodeWithText("Неуспешная авторизация")
            .assertIsDisplayed()
    }
}