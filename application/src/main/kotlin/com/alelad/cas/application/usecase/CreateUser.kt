package com.alelad.cas.application.usecase

import com.alelad.cas.application.model.CreateUserRequest
import com.alelad.cas.application.model.CreateUserResponse

interface CreateUser {
    suspend fun create(request: CreateUserRequest): CreateUserResponse
}
