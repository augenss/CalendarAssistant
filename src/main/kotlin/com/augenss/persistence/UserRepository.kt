package com.augenss.persistence

import com.augenss.model.User
import com.augenss.model.Users
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun saveUserToDb(user: User) {
    transaction {
        val userId = Users.insertAndGetId {
            it[username] = user.username
            it[password] = user.password
            it[name] = user.name
//            it[surname] = user.surname //TODO: what to do with optional fields?
        }
        println("Users: ${Users.selectAll()}")
    }
}