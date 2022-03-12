package com.alelad.cas.infrastructure.ktor.api.configuration

import com.alelad.cas.application.impl.CreateUserImpl

object UserConfiguration {
  val createUserUseCase = CreateUserImpl(TODO())
}
