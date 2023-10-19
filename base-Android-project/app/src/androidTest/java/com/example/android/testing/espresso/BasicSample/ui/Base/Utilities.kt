package com.example.android.testing.espresso.BasicSample.ui.Base

import android.content.Context
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers

/**
 * Get localized string
 * @param id pass unique id for specific element, which should be on view
 * @return localized string
 * */
fun getLocalizedString(id: Int): String {
    val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
    return context.resources.getString(id)
}

// Elements searchers
/**
 * UI element, can be button, title, checkBox, etc
 * @param withId pass unique id for specific element, which should be on view
 * @param withText (optional) pass string to have second matcher
 * @return ViewInteraction as element
 * */
fun element(withId: Int, withText: String? = null): ViewInteraction {
    return if (withText != null) {
        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(withId),
                ViewMatchers.withText(withText)
            )
        )
    } else {
        return Espresso.onView(ViewMatchers.withId(withId))
    }
}

/**
 * Text on View
 * @param withText pass string to have second matcher
 * @param matcherType select desired matcher from TextMatcherType enum
 * @return ViewInteraction as element
 * */
fun elementByText(withText: String, matcherType: TextMatcherType): ViewInteraction {
    val matcher = when (matcherType) {
        TextMatcherType.CONTAINS -> Matchers.containsString(withText)
        TextMatcherType.STARTS_WITH -> Matchers.startsWith(withText)
        TextMatcherType.ENDS_WITH -> Matchers.endsWith(withText)
        TextMatcherType.EQUALS_IGNORE_CASE -> Matchers.equalToIgnoringCase(withText)
        else -> throw IllegalArgumentException("Unknown text matcher type: $matcherType")
    }
    return Espresso.onView(ViewMatchers.withText(matcher))
}

/**
 * Comprehensive list of text matcher types
 * */
enum class TextMatcherType {
    CONTAINS, STARTS_WITH, ENDS_WITH, EQUALS_IGNORE_CASE, MATCHES_REGEX
}

/**
 * Localized string for UI element, can be label, text, etc
 * @param withId pass unique id for specific element, which should be on view
 * @return ViewInteraction as element
 * */
fun elementsByLocalizedText(withId: Int): ViewInteraction {
    return Espresso.onView(ViewMatchers.withText(withId))
}

/**
 * Returns built String based on localizedStringId template.
 * @param localizedStringId: pass localized string id as Int
 * @param value: pass value to fill template as String
 */
fun buildStringTemplate(localizedStringId: Int, value: String) : String {
    val template = getLocalizedString(localizedStringId)
    return String.format(template, value)
}