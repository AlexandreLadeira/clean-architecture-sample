package com.alelad.cas.application.impl

import com.alelad.cas.application.model.CreateUserRequest
import com.alelad.cas.application.model.CreateUserResponse
import com.alelad.cas.application.usecase.CreateUser
import com.alelad.cas.domain.entity.User
import com.alelad.cas.domain.gateway.UserGateway

class CreateUserImpl(private val userGateway: UserGateway) : CreateUser {
    override suspend fun create(request: CreateUserRequest): CreateUserResponse =
        userGateway.create(request.name, request.password)
            .toUseCaseResponse()

    private fun User.toUseCaseResponse() = CreateUserResponse(id)
}
