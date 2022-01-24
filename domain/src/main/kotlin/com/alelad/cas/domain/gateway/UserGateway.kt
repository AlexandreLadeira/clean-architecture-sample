package com.alelad.cas.domain.gateway

import com.alelad.cas.domain.entity.User
import java.util.UUID

interface UserGateway {
    suspend fun create(name: String, password: String): User
    suspend fun find(id: UUID): User
}
