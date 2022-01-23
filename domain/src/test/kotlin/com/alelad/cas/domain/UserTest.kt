package com.alelad.cas.domain

import com.alelad.cas.domain.entity.User
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class UserTest : ShouldSpec({
    should("not exist with a name with length < 5") {
        val exception = shouldThrow<IllegalArgumentException> {
            User(name = "abcd", password = "thisIsAPassword")
        }
        exception.message shouldBe  "User name length should be between 5 and 30"
    }

    should("not exist with a name with length > 30") {
        val exception = shouldThrow<IllegalArgumentException> {
            val name = (1..31).joinToString()
            User(name = name, password = "thisIsAPassword")
        }
        exception.message shouldBe  "User name length should be between 5 and 30"
    }

    should("not exist with a password with length < 10") {
        val exception = shouldThrow<IllegalArgumentException> {
            User(name = "A Valid Name", password = "abcde")
        }
        exception.message shouldBe "User password length should be be between 10 and 40"
    }

    should("not exist with a password with length > 40") {
        val exception = shouldThrow<IllegalArgumentException> {
            val password = (1..41).joinToString()
            User(name = "A Valid Name", password = password)
        }
        exception.message shouldBe  "User password length should be be between 10 and 40"
    }
})
