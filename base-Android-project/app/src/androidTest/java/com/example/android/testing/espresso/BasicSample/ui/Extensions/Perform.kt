package com.example.android.testing.espresso.BasicSample.ui.Extensions

import android.text.SpannableString
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.widget.NumberPicker
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

/**
 * Method to set the value of a NumberPicker object in Android.
 * @param targetValue The target value to be set in the NumberPicker.
 * @return A ViewAction object that can be performed on a NumberPicker.
 * - If targetValue equals to minimum value of picker, it will swipe down and then swipe up
 * - If targetValue is greater than minimum value of picker, it will swipe up and then swipe down
 */
fun setNumberPickerValue(targetValue: Int): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isAssignableFrom(NumberPicker::class.java)
        }

        override fun getDescription(): String {
            return "Swipe up or down until the NumberPicker value matches the target value"
        }

        override fun perform(uiController: UiController, view: View) {
            val numberPicker = view as NumberPicker
            Log.d(
                "NumberPicker",
                "Curent value: ${numberPicker.value} | Max: ${numberPicker.maxValue} | Min: ${numberPicker.minValue}"
            )
            numberPicker.value = targetValue

            if (numberPicker.value == numberPicker.minValue) {
                GeneralSwipeAction(
                    Swipe.SLOW,
                    GeneralLocation.BOTTOM_CENTER,
                    GeneralLocation.CENTER,
                    Press.FINGER
                ).perform(uiController, view)
                GeneralSwipeAction(
                    Swipe.SLOW,
                    GeneralLocation.CENTER,
                    GeneralLocation.BOTTOM_CENTER,
                    Press.FINGER
                ).perform(uiController, view)
            } else {
                GeneralSwipeAction(
                    Swipe.SLOW,
                    GeneralLocation.CENTER,
                    GeneralLocation.BOTTOM_CENTER,
                    Press.FINGER
                ).perform(uiController, view)
                GeneralSwipeAction(
                    Swipe.SLOW,
                    GeneralLocation.BOTTOM_CENTER,
                    GeneralLocation.CENTER,
                    Press.FINGER
                ).perform(uiController, view)
            }
        }
    }
}

/**
 * ViewAction to perform a click on specific spannable portion of the text
 * used to click on hyperlinks
 */
class SpannableTextClickAction(val text: String) : ViewAction {
    override fun getDescription(): String = "SpannableText click action"

    override fun getConstraints(): Matcher<View> =
        ViewMatchers.isAssignableFrom(TextView::class.java)

    override fun perform(uiController: UiController?, view: View?) {
        val textView = view as TextView
        val spannableString = textView.text as SpannableString
        val spans = spannableString.getSpans(0, spannableString.count(), ClickableSpan::class.java)
        val spanToLocate = spans.firstOrNull { span: ClickableSpan ->
            val start = spannableString.getSpanStart(span)
            val end = spannableString.getSpanEnd(span)
            val spanText = spannableString.subSequence(start, end).toString()
            spanText == text
        }
        if (spanToLocate != null) {
            spanToLocate.onClick(textView)
            return
        }
    }
}
