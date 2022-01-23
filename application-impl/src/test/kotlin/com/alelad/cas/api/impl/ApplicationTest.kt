package com.alelad.cas.api.impl

import com.alelad.cas.api.impl.plugins.configureRouting
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication

class ApplicationTest : BehaviorSpec({
    Given("a ktor api") {
        When("it runs") {
            Then("it respond a GET(/) with successfully") {
                withTestApplication({ configureRouting() }) {
                    handleRequest(HttpMethod.Get, "/").apply {
                        response.status() shouldBe HttpStatusCode.OK
                        response.content shouldBe "Hello World!"
                    }
                }
            }
        }
    }
})

