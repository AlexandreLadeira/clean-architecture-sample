val mockkVersion: String by project

dependencies {
    api(project(":application"))

    testImplementation("io.mockk:mockk:$mockkVersion")
}
