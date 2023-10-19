# Native Automation for Android

This project aims to automate testing for native mobile applications developed for Android platforms, this project will be using **Kotlin** as programming language and **Espresso** as the Testing framework

## Project Objective

Test automation on mobile devices can be performed with different tools, such as Detox or Appium. These tools will be useful when the application is developed with a cross-platform approach, for example applications made with react-native or flutter. On the other hand, when the applications are native for each platform, the native automation approach appears. In this repository you will find examples of how this automation can be done for Android platforms.

## Requirements
Make sure you have the following tools and environments set up on your system before running the tests:

- Android Studio: For Android test development and execution.
- Android Emulators: This ones come with Android Studio. If the computer where these will be used is Apple Chip you will need to install rosetta to run emulators.
- Kotlin: The programming language used in the automation project.

## Getting Started
- `cd` into `base-Android-project`

- Run Android Tests from terminal: ```make run-tests``` (You must be located on project root directory to run this command)
For more information about the commands that are being executed to run the test check the Makefile

## Folder Structure
- **Base**: Setup and Teardown configuration
- **Extensions**: Base interactions extending **ViewInteraction** class
- **GenericComponents**: Generic way to interact with reused components
- **Screens**: Page Object Models for the app screens
- **TestData**: Test data to use in tests
- **Tests**: Test scripts

## Getting the elements
App should be running on device (emulator or physical) and **Layout Inspector** is the better helper to grab the elements ids.

## Resources
- [Andorid Espresso Course](https://youtu.be/lZ8Yx0Azx_A?feature=shared)
- [Espresso examples and cheatsheet](https://www.tutorialspoint.com/espresso_testing/espresso_testing_view_actions.htm)

## Base App Source
- [Android](https://github.com/android/testing-samples/tree/main/ui/espresso/BasicSample)