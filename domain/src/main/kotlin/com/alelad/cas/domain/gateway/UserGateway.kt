package com.alelad.cas.domain.gateway

import com.alelad.cas.domain.entity.User
import com.alelad.cas.domain.entity.UserId

interface UserGateway {
    suspend fun create(user: User): User
    suspend fun find(id: UserId): User
}
