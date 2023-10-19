package com.example.android.testing.espresso.BasicSample.ui.Base

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.android.testing.espresso.BasicSample.MainActivity
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
open class UITestBase {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()


    companion object {
        /**
         * to run before each test class
         */
        @BeforeClass
        @JvmStatic
        fun setupClass() {}

        /**
         * to run after each test class
         */
        @AfterClass
        @JvmStatic
        fun tearDownClass() {}
    }

    /**
     * to run before each test
     */
    @Before
    open fun setup() {
    }

    /**
     * to run after each test
     */
    @After
    open fun tearDown() {
    }
}