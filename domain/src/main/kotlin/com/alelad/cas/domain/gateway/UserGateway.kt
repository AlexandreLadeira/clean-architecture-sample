package com.alelad.cas.domain.gateway

import com.alelad.cas.domain.entity.User
import com.alelad.cas.domain.entity.UserId

interface UserGateway {
    suspend fun create(name: String, password: String): User
    suspend fun find(id: UserId): User
}
