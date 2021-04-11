package com.augenss.dto

import com.augenss.model.User
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
    fun toUser(): User = User(username, password, name, surname)
}