// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}
// build.gradle.kts (Project-level)

buildscript {
    repositories {
        google()
        mavenCentral() // Add this line to use mavenCentral
    }
    dependencies {
        // Your buildscript dependencies
    }
}

