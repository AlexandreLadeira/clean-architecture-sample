val kotlinVersion: String by project
val version: String by project

plugins {
    kotlin("jvm") version "1.6.10" // kotlinVersion must be set explicitly under plugins {...}
}

allprojects {
    group = "com.alelad"

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
    }
}
