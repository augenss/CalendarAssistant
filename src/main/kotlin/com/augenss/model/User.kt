package com.augenss.model

import org.jetbrains.exposed.dao.id.IntIdTable

data class User (
    val id: Int,
    val username: String,
    val password: String,
    val name: String,
//    val surname: String?
)

/** Users is the mapping object for User */
object Users: IntIdTable() {
    val username = varchar("username", 50)
    val password = varchar("password", 50)
    val name = varchar("name", 50)
//    val surname = varchar("surname", 50)
}