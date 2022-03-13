val awsSdkVersion: String by project

dependencies {
    implementation("aws.sdk.kotlin:dynamodb:$awsSdkVersion")

    implementation(project(":domain"))
}
