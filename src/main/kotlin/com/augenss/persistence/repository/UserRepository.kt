package com.augenss.persistence.repository

import com.augenss.dao.UserDao
import com.augenss.dao.UsersTable
import com.augenss.dto.UserDto
import com.augenss.model.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun createUsersTable() {
    transaction {
        SchemaUtils.create(UsersTable)
    }
}

fun getUsersFromDb(): List<User> {
    return transaction {
        UserDao.all().toList().map { it.toUser() }
    }
}

fun getUserFromDb(id: Int): UserDao? {
    return transaction {
        UserDao.findById(id)
    }
}

fun saveUserToDb(userDto: UserDto) {
    transaction {
        val userDao = UserDao.new {
            username = userDto.username
            password = userDto.password
            name = userDto.name
            surname = userDto.surname
        }
        println("Added user " + userDao.username) // TODO: fix this prints also when error, like users table doesn't exist
    }
}

fun updateUserInDb(userDto: UserDto) {
    requireNotNull(userDto.id)
    val userDao = getUserFromDb(userDto.id)
    requireNotNull(userDao)
    transaction {
        userDao.username = userDto.username
        userDao.password = userDto.password
        userDao.name = userDto.name
        userDao.surname = userDto.surname
    }
    println("Updated user " + userDto.username)
}

fun deleteUserFromDb(id: Int) {
    val userDao = getUserFromDb(id)
    transaction {
        userDao?.delete()
    }
}