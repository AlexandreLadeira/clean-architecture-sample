package com.alelad.cas.domain.gateway

import com.alelad.cas.domain.entity.User
import java.util.UUID

interface UserGateway {
    suspend fun create(request: CreateUserRequest): User
    suspend fun find(request: FindUserRequest): User

    data class CreateUserRequest(val name: String, val password: String)
    data class FindUserRequest(val id: UUID)
}
