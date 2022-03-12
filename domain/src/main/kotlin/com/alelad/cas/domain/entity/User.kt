package com.alelad.cas.domain.entity

import java.util.UUID

typealias UserId = UUID

data class User(
    val id: UserId = UserId.randomUUID(),
    val name: String,
    val password: String
) {
    init {
        require(name.length in 5..30) {
            "User name length should be between 5 and 30"
        }

        require(password.length in 10..40) {
            "User password length should be be between 10 and 40"
        }
    }
}
