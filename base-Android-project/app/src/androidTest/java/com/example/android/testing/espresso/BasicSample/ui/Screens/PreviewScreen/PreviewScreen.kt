package com.example.android.testing.espresso.BasicSample.ui.Screens.PreviewScreen

import androidx.test.espresso.ViewInteraction
import com.example.android.testing.espresso.BasicSample.R
import com.example.android.testing.espresso.BasicSample.ui.Base.FlowInitializersScreen
import com.example.android.testing.espresso.BasicSample.ui.Base.element
import com.example.android.testing.espresso.BasicSample.ui.Extensions.assertExistence
import com.example.android.testing.espresso.BasicSample.ui.Extensions.assertTextEquals
import com.example.android.testing.espresso.BasicSample.ui.Extensions.waitUntilDisplayed

class PreviewScreen {

    // Base View
    private val textView: ViewInteraction by lazy { element(R.id.show_text_view) }

    // Then
    fun thenAssertTextViewAppears() {
        textView.waitUntilDisplayed()
        textView.assertExistence()
    }

    fun thenAssertTextViewDisplayCorrectText(expectedText: String) {
        textView.assertTextEquals(expectedText)
    }
}