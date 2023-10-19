package com.example.android.testing.espresso.BasicSample.ui.Base

import com.example.android.testing.espresso.BasicSample.ui.Screens.HomeScreen.HomeScreen
import com.example.android.testing.espresso.BasicSample.ui.Screens.PreviewScreen.PreviewScreen

open class FlowInitializersScreen: UITestBase() {
    val homeScreen = HomeScreen()
    val previewScreen = PreviewScreen()
}