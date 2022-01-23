val kotlinVersion: String by project
val kotestVersion: String by project
val version: String by project

plugins {
    kotlin("jvm") version "1.6.10" // kotlinVersion must be set explicitly under plugins {...}
}

allprojects {
    group = "com.alelad.cas"

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        mavenLocal()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    dependencies {
        testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
        testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    }
}
