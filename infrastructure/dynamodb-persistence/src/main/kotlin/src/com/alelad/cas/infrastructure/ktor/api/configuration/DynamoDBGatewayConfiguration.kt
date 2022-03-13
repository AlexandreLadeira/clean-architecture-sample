package src.com.alelad.cas.infrastructure.ktor.api.configuration

import aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider
import aws.sdk.kotlin.services.dynamodb.DynamoDbClient
import src.com.alelad.cas.infrastructure.ktor.api.gateway.DynamoDBUserGateway

class DynamoDBGatewayConfiguration(profileName: String) {
    private val dynamoDbClient = DynamoDbClient {
        region = "use-east-1"
        credentialsProvider = ProfileCredentialsProvider(profileName)
    }

    fun newUserGateway() = DynamoDBUserGateway(dynamoDbClient).also {
        println("teste")
    }
}
