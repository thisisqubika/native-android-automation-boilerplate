package com.example.android.testing.espresso.BasicSample.ui.TestData

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * Test User Entity to grab user information
 * @param firstName: optional, refers to user firstName
 * @param lastName: optional, refers to user lastName
 * @param birthDay: optional, refers to user birthDate
 * @param username: refers to user email
 * @param password: refers to user password, default: Prueba123!
 */
class TestUser(val firstName: String? = "Test",
               val lastName: String? = "Test",
               val birthDay: LocalDate = LocalDate.now(),
               val userEmail: String,
               val gender: Gender = Gender.MALE,
               val height: MeasurementSystemsHeight? = MeasurementSystemsHeight.IMPERIAL,
               val weight: MeasurementSystemsWeight? = MeasurementSystemsWeight.IMPERIAL,
               val password: String = "Prueba123!"){

    enum class Gender(val genderValue: String) {
        MALE("Male"),
        FEMALE("Female")
    }

    enum class MeasurementSystemsWeight(val unitValue: Int) {
        IMPERIAL(170),
        METRIC(80)
    }

    enum class MeasurementSystemsHeight(val unitValue: Int) {
        IMPERIAL(6),
        METRIC(180)
    }

    /**
     * Method to get the date of birth in the format of "Month day, Year".
     * @return A String representing the birth day in the format of "Month day, Year".
     */
    fun getMonthDayLongYear(): String {
        val formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH)
        return birthDay.format(formatter)
    }
}