package com.alelad.cas.infrastructure.ktor.api.model

import com.alelad.cas.application.model.CreateUserRequest
import com.alelad.cas.application.model.CreateUserResponse
import java.util.UUID
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequestDTO(val name: String, val password: String) {
  fun toUseCaseRequest() = CreateUserRequest(name, password)
}

@Serializable
data class CreateUserResponseDTO(
  val userId: String,
  val requestId: String // just to show that the API response could be different from the actual domain entity
)

fun CreateUserResponse.toDTO() = CreateUserResponseDTO(
  userId = id.toString(),
  requestId = UUID.randomUUID().toString()
)
