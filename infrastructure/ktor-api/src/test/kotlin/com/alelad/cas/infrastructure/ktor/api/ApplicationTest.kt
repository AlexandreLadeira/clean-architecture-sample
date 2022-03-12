package com.alelad.cas.infrastructure.ktor.api

import com.alelad.cas.infrastructure.ktor.api.plugins.configureRouting
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication

class ApplicationTest : BehaviorSpec({
    Given("a ktor api") {
        When("it runs") {
            Then("it respond a GET(/) with successfully") {
                testApplication {
                    application {
                        configureRouting()
                    }

                    val response = client.get("/")
                    response.status shouldBe HttpStatusCode.OK
                    response.bodyAsText() shouldBe "Hello World!"
                }
            }
        }
    }
})

