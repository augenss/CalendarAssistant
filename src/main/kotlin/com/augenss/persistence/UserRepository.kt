package com.augenss.persistence

import com.augenss.model.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun createUsersTable() {
    transaction {
        SchemaUtils.create(Users)
    }
}

fun saveUserToDb() {
    transaction {
        val userId = Users.insertAndGetId {
            it[username] = "testusername"
            it[password] = "testpswd"
            it[name] = "testname"
//            it[surname] = user.surname //TODO: what to do with optional fields?
        }
        println("Users: ${Users.selectAll()}")
    }
}
