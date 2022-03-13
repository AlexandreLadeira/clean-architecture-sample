package src.com.alelad.cas.infrastructure.ktor.api.gateway

import aws.sdk.kotlin.services.dynamodb.DynamoDbClient
import aws.sdk.kotlin.services.dynamodb.model.AttributeValue
import aws.sdk.kotlin.services.dynamodb.model.GetItemResponse
import com.alelad.cas.domain.entity.User
import com.alelad.cas.domain.entity.UserId
import com.alelad.cas.domain.gateway.UserGateway

class DynamoDBUserGateway(private val dynamoDbClient: DynamoDbClient) : UserGateway {
    override suspend fun create(user: User): User {
        dynamoDbClient.putItem {
            tableName = TABLE_NAME
            item = mapOf(
                ID to AttributeValue.S(user.id.toString()),
                NAME to AttributeValue.S(user.name),
                PASSWORD to AttributeValue.S(user.password)
            )
        }
        return user
    }

    override suspend fun find(id: UserId): User =
        dynamoDbClient.getItem {
            key = mapOf(ID to AttributeValue.S(id.toString()))
        }.toUser()

    private fun GetItemResponse.toUser() = item?.let {
        User(
            id = UserId.fromString(it[ID].toString()),
            name = it[NAME].toString(),
            password = it[PASSWORD].toString()
        )
    } ?: throw IllegalStateException("Invalid response from db to load user")

    private companion object {
        const val TABLE_NAME = "user"

        const val ID = "id"
        const val NAME = "name"
        const val PASSWORD = "password"
    }
}
