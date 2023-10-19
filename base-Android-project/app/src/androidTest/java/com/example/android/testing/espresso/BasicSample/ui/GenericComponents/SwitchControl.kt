package com.example.android.testing.espresso.BasicSample.ui.GenericComponents

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.example.android.testing.espresso.BasicSample.ui.Base.element
import com.example.android.testing.espresso.BasicSample.ui.Base.elementsByLocalizedText
import com.example.android.testing.espresso.BasicSample.ui.Extensions.assertExistence
import com.example.android.testing.espresso.BasicSample.ui.Extensions.assertSelected
import com.example.android.testing.espresso.BasicSample.ui.Extensions.assertState
import com.example.android.testing.espresso.BasicSample.ui.Extensions.getChecked
import com.example.android.testing.espresso.BasicSample.ui.Extensions.scrollToElement
import com.example.android.testing.espresso.BasicSample.ui.Extensions.tap

class SwitchControl {
    /**
     * SwitchControl class represent all possible switchers as `Toggle, CheckBox, RadioSelectionButton`
     * @param baseID: As Int, represents the unique identifier for element
     * @param text: Optional, represents the label next to the switcher, Pass as Int unique identifier
     * @param button: Represents the button associated with the switch control
     * @param title: Represents the text label associated to the switch control
     */
    class SwitchControl(val baseID: Int,
                        val text: Int? = null,
                        val button: ViewInteraction,
                        val title: ViewInteraction? = null) {


        // Checkbox with title constructor
        constructor(baseID: Int, text: Int) : this(
            baseID,
            text,
            button = element(baseID),
            title = elementsByLocalizedText(text)
        )

        // Switch only constructor
        constructor(baseID: Int) : this(
            baseID,
            button = element(baseID)
        )

        // Assertions
        /**
         * Asserts button enabled attribute value
         * @param enabled expected value
         */
        fun assertState(enabled: Boolean) {
            Log.d("Switch Control", "Assert button state is $enabled")
            button.assertState(enabled)
        }

        /**
         * Asserts button checked attribute value
         * @param selected
         */
        fun assertCheckedState(selected: Boolean) {
            Log.d("Switch Control", "Assert button checked state is $selected")
            button.assertSelected(selected)
        }

        /**
         * Assert button existence
         */
        fun assertExistence() {
            Log.d("Switch Control", "Assert button Existance")
            button.assertExistence()
            title?.assertExistence()
        }

        // Help functions
        /**
         * Get checked attribute information
         * @return True if button is checked, False is button is not checked
         */
        fun getCheckedState(): Boolean {
            Log.d("Test", "${button.getChecked()}")
            return button.getChecked()
        }

        // Interactions
        /**
         * Sets the switcher state
         * @param enabled target state
         * @param scrollToElement pass as Boolean, defaults to false
         */
        fun setStateTo(enabled: Boolean, scrollToElement: Boolean = false) {
            if( getCheckedState() != enabled ) {
                if (scrollToElement) {
                    button.scrollToElement()
                    tap()
                } else {
                    tap()
                }
            }
        }

        /**
         * Taps on button
         */
        fun tap() {
            button.tap()
        }
    }
}