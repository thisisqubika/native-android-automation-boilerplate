package com.example.android.testing.espresso.BasicSample.ui.Tests

import com.example.android.testing.espresso.BasicSample.ui.Base.FlowInitializersScreen
import org.junit.Test

class HomeScreenUITests: FlowInitializersScreen() {

    val textToBeTyped: String = "Test"
    @Test
    fun testChangeText() {
        homeScreen.thenAllElementsAppear()
        homeScreen.whenITypeText(textToBeTyped)
        homeScreen.whenITapChangeText()
        homeScreen.thenAssertNewValue(textToBeTyped)
    }

    @Test
    fun testChangeActivityAndText() {
        homeScreen.thenAllElementsAppear()
        homeScreen.whenITypeText(textToBeTyped)
        homeScreen.whenITapActivityChange()
        previewScreen.thenAssertTextViewAppears()
        previewScreen.thenAssertTextViewDisplayCorrectText(textToBeTyped)
    }
}