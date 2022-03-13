package com.alelad.cas.application.impl

import com.alelad.cas.application.model.CreateUserRequest
import com.alelad.cas.domain.entity.User
import com.alelad.cas.domain.gateway.UserGateway
import io.kotest.core.spec.style.ShouldSpec
import io.mockk.clearMocks
import io.mockk.coVerify
import io.mockk.mockk

class CreateUserImplTest : ShouldSpec({
    val userGateway = mockk<UserGateway>(relaxed = true)

    val createUserImpl = CreateUserImpl(userGateway)

    afterTest {
        clearMocks(userGateway)
    }

    should("should call the user gateway to create one") {
        val request = CreateUserRequest("NewUser", "NewUserPassword")
        createUserImpl.create(request)

        coVerify { userGateway.create(User(any(), request.name, request.password)) }
    }
})
