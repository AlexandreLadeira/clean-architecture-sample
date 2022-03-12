package com.alelad.cas.infrastructure.ktor.api

import com.alelad.cas.infrastructure.ktor.api.plugins.configureRouting
import com.alelad.cas.infrastructure.ktor.api.plugins.configureSerialization
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
