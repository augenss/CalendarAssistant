package com.augenss.dto

import com.augenss.model.User
import com.augenss.model.UserId
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
        val id: Int? = null,
        val username: String,
        val password: String,
        val name: String,
        val surname: String? = null
)
{
    fun toUser(): User = when (id) {
            null -> User(null, username, password, name, surname)
            else -> User(UserId(id), username, password, name, surname)
        }
}