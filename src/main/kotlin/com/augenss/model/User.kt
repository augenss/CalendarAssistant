package com.augenss.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.IntIdTable

@Serializable
data class User (
    val id: Int,
    val username: String,
    val password: String,
    val name: String,
//    val surname: String?
)

object Users: IntIdTable() {
    val username = varchar("username", 50)
    val password = varchar("password", 50)
    val name = varchar("name", 50)
//    val surname = varchar("surname", 50)
}