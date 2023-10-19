package com.example.android.testing.espresso.BasicSample.ui.Extensions

import android.util.Log
import android.view.View
import android.widget.Checkable
import android.widget.ScrollView
import android.widget.TextView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import junit.framework.TestCase
import org.hamcrest.Matcher
import org.hamcrest.Matchers

// Assertions
/**
 * Assert element exists on screen
 * */
fun ViewInteraction.assertExistence() {
    this.check(ViewAssertions.matches(Matchers.not(ViewAssertions.doesNotExist())))
}

/**
 * Assert element state
 * @param isEnabled pass boolean, true for enabled and false for disabled
 * */
fun ViewInteraction.assertState(isEnabled: Boolean) {
    if (isEnabled) {
        this.check(ViewAssertions.matches(ViewMatchers.isEnabled()))
    } else {
        this.check(ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled())))
    }
}

/**
 * Asserts button attribute checked matches isChecked param
 * @param isChecked: Expected checked value
 */
fun ViewInteraction.assertSelected(isSelected: Boolean) {
    if (isSelected) {
        this.check(ViewAssertions.matches(ViewMatchers.isChecked()))
    } else {
        this.check(ViewAssertions.matches(Matchers.not(ViewMatchers.isChecked())))
    }
}

/**
 * Assert element label equal to desired string
 * @param expectedResult pass string
 * */
fun ViewInteraction.assertLabelEqual(expectedResult: String) {
    this.check(ViewAssertions.matches(ViewMatchers.withText(expectedResult)))
}

/**
 * Assert element is visible
 * */
fun ViewInteraction.assertVisible() {
    this.check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

/**
 * Assert element is NOT visible
 * */
fun ViewInteraction.assertNotVisible() {
    this.check(ViewAssertions.doesNotExist())
}

/**
 * Assert view is scrollable
 * */
fun ViewInteraction.assertScrollable() {
    this.check(ViewAssertions.matches(ViewMatchers.isAssignableFrom(ScrollView::class.java)))
}

/**
 * Assert current element text equals expectedText
 * @param expectedText: Pass as String, Expected text on element
 */
fun ViewInteraction.assertTextEquals(expectedText: String) {
    val currentText: String = this.getText()
    TestCase.assertEquals("Given texts are not equal", currentText, expectedText)
}

// Actions
/**
 * Gets the checked attribute information for element
 */
fun ViewInteraction.getChecked(): Boolean {
    var isChecked = false
    this.check { view, _ ->
        isChecked = (view as Checkable).isChecked
    }
    return isChecked
}

/**
 * Gets the text from the element
 */
fun ViewInteraction.getText(): String {
    var text = String()
    this.perform(object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isAssignableFrom(TextView::class.java)
        }

        override fun getDescription(): String {
            return "Text of the view"
        }

        override fun perform(uiController: UiController, view: View) {
            val tv = view as TextView
            text = tv.text.toString()
        }
    })
    return text
}

/**
 * Taps on element
 * */
fun ViewInteraction.tap() {
    this.perform(ViewActions.click())
}

/**
 * Scroll to element
 * */
fun ViewInteraction.scrollToElement() {
    this.perform(ViewActions.scrollTo())
}

/**
 * Taps on given spannable text
 * @param text: Pass as String
 */
fun ViewInteraction.tapSpannableText(text: String) {
    this.perform(SpannableTextClickAction(text))
}

/**
 * Waits for a matching View or throws an error if it's taking too long.
 */
fun ViewInteraction.waitUntilDisplayed() {
    Log.d("IdlingResourceDebug", "Creating New Idle resource for $this")
    val idlingResource: IdlingResource = ViewIdlingResource(this, ViewMatchers.isDisplayed())
    try {
        IdlingRegistry.getInstance().register(idlingResource)
        // First call to onView is to trigger the idler.
        this.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    } finally {
        IdlingRegistry.getInstance().unregister(idlingResource)
        Log.d("IdlingResourceDebug", "Unregister Idle resource for $this")
    }
}

/**
 * Clear field content, type new text and closes keyboard
 * @param textToBeTyped string to be typed
 */
fun ViewInteraction.clearAndTypeIntoElement(textToBeTyped: String) {
    this.perform(
        ViewActions.clearText(),
        ViewActions.typeText(textToBeTyped),
        ViewActions.closeSoftKeyboard()
    )
}

// List of scroll directions
enum class ScrollDirection {
    UP, DOWN, LEFT, RIGHT
}

/**
 * Performs scroll action to given scroll direction
 * @param direction: Pass Scroll Direction
 */
fun ViewInteraction.swipe(direction: ScrollDirection) {
    when(direction) {
        ScrollDirection.UP -> this.perform(ViewActions.swipeUp())
        ScrollDirection.DOWN -> this.perform(ViewActions.swipeDown())
        ScrollDirection.LEFT -> this.perform(ViewActions.swipeLeft())
        ScrollDirection.RIGHT -> this.perform(ViewActions.swipeRight())
    }
}

/**
 * Taps on BackButton
 * @param unconditionally: Press back button and does not throw any exception if the app is closed
 */
fun ViewInteraction.pressBackButton(unconditionally: Boolean = false) {
    if(unconditionally) {
        this.perform(ViewActions.pressBackUnconditionally())
    } else {
        this.perform(ViewActions.pressBack())
    }
}