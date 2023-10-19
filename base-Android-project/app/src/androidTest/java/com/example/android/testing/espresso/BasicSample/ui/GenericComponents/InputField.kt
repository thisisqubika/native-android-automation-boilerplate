package com.example.android.testing.espresso.BasicSample.ui.GenericComponents

import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.example.android.testing.espresso.BasicSample.ui.Base.element
import com.example.android.testing.espresso.BasicSample.ui.Base.elementsByLocalizedText
import com.example.android.testing.espresso.BasicSample.ui.Extensions.assertExistence
import com.example.android.testing.espresso.BasicSample.ui.Extensions.assertTextEquals
import com.example.android.testing.espresso.BasicSample.ui.Extensions.clearAndTypeIntoElement
import com.example.android.testing.espresso.BasicSample.ui.Extensions.getText
import com.example.android.testing.espresso.BasicSample.ui.Extensions.tap

/**
 * InputField class represent all possible text fields and it's components
 * @param baseID: As Int, represents the unique identifier for element
 * @param placeHolderID: As Int, represents the string identifier for the placeholder text
 * @param errorMessageID: As Int, represents the unique identifier for error message element
 * @param textField: Represents the Text Field element associated to the Input Field
 * @param errorMessage: Represents the Error Message element associated to the Input Field
 * @param eyeButton: Represents the Eye button element associated to the Input Field
 */
class InputField (val baseID: Int,
                  val placeHolderID: Int? = null,
                  val errorMessageID: Int? = null,
                  val textField: ViewInteraction,
                  val errorMessage: ViewInteraction? = null,
                  val eyeButton: ViewInteraction? = null) {

    // Constructor for Input Field without Eye button
    constructor(baseID: Int, placeHolderID: Int, errorMessageID: Int): this (
        baseID,
        placeHolderID,
        errorMessageID,
        textField = element(baseID),
        errorMessage = elementsByLocalizedText(errorMessageID)
    )

    // Constructor for Input Field with Eye button
    constructor(baseID: Int, placeHolderID: Int, errorMessageID: Int, eyeButton: ViewInteraction): this (
        baseID,
        placeHolderID,
        errorMessageID,
        textField = element(baseID),
        errorMessage = elementsByLocalizedText(errorMessageID),
        eyeButton
    )

    // Assertions
    /**
     * Asserts Input field existence
     */
    fun assertExistence() {
        Log.d("Input Field", "Assert Input Field existence")
        textField.assertExistence()
    }

    /**
     * Asserts Input field error message exists
     */
    fun assertErrorMessage() {
        Log.d("Input Field", "Assert error message existence")
        errorMessage?.assertExistence()
    }

    /**
     * Asserts Input field placeholder exists
     */
    fun assertPlaceholder() {
        Log.d("Input Field", "Assert Input Field placeholder")
        Espresso.onView(placeHolderID?.let { ViewMatchers.withHint(it) })
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    /**
     * Asserts Input field content matches given text
     * @param text: Expected text
     */
    fun assertContentEquals(text: String) {
        Log.d("Input Field", "Assert Input Field content matches $text")
        textField.assertTextEquals(text)
    }

    // Interactions
    /**
     * Clears content and types into Input Field
     * @param text: Text to be typed
     */
    fun clearAndInputText(text: String) {
        textField.clearAndTypeIntoElement(text)
    }

    /**
     * Returns Input Field content as String
     */
    fun getText() : String {
        return textField.getText()
    }

    /**
     * Taps on Eye Button
     */
    fun tapEyeButton() {
        eyeButton?.tap()
    }
}