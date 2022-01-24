val mockkVersion: String by project

dependencies {
    implementation(project(":application"))
    implementation(project(":domain"))

    testImplementation("io.mockk:mockk:$mockkVersion")
}
