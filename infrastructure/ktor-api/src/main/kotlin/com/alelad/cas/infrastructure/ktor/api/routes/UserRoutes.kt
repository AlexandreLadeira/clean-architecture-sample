package com.alelad.cas.infrastructure.ktor.api.routes

import com.alelad.cas.infrastructure.ktor.api.configuration.UserConfiguration.createUserUseCase
import com.alelad.cas.infrastructure.ktor.api.model.CreateUserRequestDTO
import com.alelad.cas.infrastructure.ktor.api.model.toDTO
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import io.ktor.server.routing.route

fun Route.userRouting() {
    route("/user") {

        post {
            val requestDTO = call.receive<CreateUserRequestDTO>()
            val response = createUserUseCase.create(requestDTO.toUseCaseRequest())
            call.respond(response.toDTO())
        }
    }
}
