package com.example.android.testing.espresso.BasicSample.ui.TestData

import com.example.android.testing.espresso.BasicSample.ui.Extensions.Random
import java.time.LocalDate

object Users {
    public val invalidUser = TestUser(
        userEmail = "invalid@user.",
        password = "test"
    )
    public val user4321 = TestUser(userEmail = "test@test.com")
    public val user8177 = TestUser(userEmail = "nebribawetre-8177@yopmail.com")
}

val newImperialMaleUser: TestUser = TestUser(firstName = "Test",
    lastName = "Test",
    birthDay = LocalDate.now().minusYears(21),
    userEmail = Random.email(),
    height = TestUser.MeasurementSystemsHeight.IMPERIAL,
    weight = TestUser.MeasurementSystemsWeight.IMPERIAL)


val newMetricFemaleUser: TestUser = TestUser(firstName = "Test",
    lastName = "Test",
    birthDay = LocalDate.now().minusYears(21),
    userEmail = Random.email(),
    height = TestUser.MeasurementSystemsHeight.METRIC,
    weight = TestUser.MeasurementSystemsWeight.METRIC,
    gender = TestUser.Gender.FEMALE)

fun newRandomUser(): TestUser {
    return TestUser(userEmail = Random.email())
}