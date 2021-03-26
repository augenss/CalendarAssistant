package com.augenss.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto (
    val username: String,
    val password: String,
    val name: String,
//    val surname: String?
        )