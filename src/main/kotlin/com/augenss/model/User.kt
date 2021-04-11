package com.augenss.model

import com.augenss.dto.UserDto

data class User(
        val id: UserId,
        val username: String,
        val password: String,
        val name: String,
        val surname: String?
)
{
    fun toUserDto(): UserDto = UserDto(id.raw, username, password, name, surname)
    // fun hashPassword()
}

data class UserId(val raw: Int)
