package com.example.android.testing.espresso.BasicSample.ui.Screens.HomeScreen

import androidx.test.espresso.ViewInteraction
import com.example.android.testing.espresso.BasicSample.ui.Base.element
import com.example.android.testing.espresso.BasicSample.R
import com.example.android.testing.espresso.BasicSample.ui.Extensions.assertExistence
import com.example.android.testing.espresso.BasicSample.ui.Extensions.assertLabelEqual
import com.example.android.testing.espresso.BasicSample.ui.Extensions.assertTextEquals
import com.example.android.testing.espresso.BasicSample.ui.Extensions.clearAndTypeIntoElement
import com.example.android.testing.espresso.BasicSample.ui.Extensions.getText
import com.example.android.testing.espresso.BasicSample.ui.Extensions.tap
import com.example.android.testing.espresso.BasicSample.ui.Extensions.waitUntilDisplayed

class HomeScreen {
    // Text Field
    private val textField: ViewInteraction by lazy { element(R.id.editTextUserInput) }

    // Buttons
    private val changeTextButton: ViewInteraction by lazy { element(R.id.changeTextBt) }
    private val activityChangeTextButton: ViewInteraction by lazy { element(R.id.activityChangeTextBtn) }

    // Static Text
    private val textToBeChanged: ViewInteraction by lazy { element(R.id.textToBeChanged) }

    // Then
    fun thenAllElementsAppear() {
        textField.waitUntilDisplayed()
        textField.assertExistence()
        changeTextButton.assertExistence()
        activityChangeTextButton.assertExistence()
        textToBeChanged.assertExistence()
    }

    fun thenAssertNewValue(newValue: String) {
        textField.assertTextEquals(newValue)
    }

    // When
    fun whenITypeText(text: String) {
        textField.clearAndTypeIntoElement(text)
    }

    fun whenITapChangeText() {
        changeTextButton.tap()
    }

    fun whenITapActivityChange() {
        activityChangeTextButton.tap()
    }
}