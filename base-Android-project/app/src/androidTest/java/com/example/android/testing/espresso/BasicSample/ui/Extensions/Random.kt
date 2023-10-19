package com.example.android.testing.espresso.BasicSample.ui.Extensions

class Random {
    companion object {
        // List of email domains
        enum class DomainTypes(val domainValue: String) {
            GMAIL("gmail.com"),
            TEST("test.com"),
            SUPER_TEST("supertest.com")
        }

        /**
         * Generates a random email
         * @param text: Enter text to be typed before random number. Default: "test+"
         * @param domain: Domain of the random email. Default: "@test.com"
         */
        fun email(text: String = "test+", domain: DomainTypes = DomainTypes.TEST): String {
            return "${text}${number()}@${domain.domainValue}"
        }

        // Generates a random number between 1 and 999999999
        fun number(): Int {
            val randomNumber = (1..999999999).random()
            return randomNumber;
        }
    }
}