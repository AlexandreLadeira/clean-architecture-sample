package com.alelad.cas.infrastructure.ktor.api.configuration

import com.alelad.cas.application.impl.CreateUserImpl
import com.alelad.cas.infrastructure.ktor.api.configuration.GatewayConfiguration.userGateway

object UserConfiguration {
  val createUserUseCase = CreateUserImpl(userGateway)
}
