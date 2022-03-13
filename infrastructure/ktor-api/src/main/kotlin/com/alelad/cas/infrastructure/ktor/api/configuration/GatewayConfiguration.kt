package com.alelad.cas.infrastructure.ktor.api.configuration

import src.com.alelad.cas.infrastructure.ktor.api.configuration.DynamoDBGatewayConfiguration

object GatewayConfiguration {
    // TODO get profileName from configuration file
    private val dynamoDBConfig = DynamoDBGatewayConfiguration("local-teste")

    val userGateway = dynamoDBConfig.newUserGateway()
}
