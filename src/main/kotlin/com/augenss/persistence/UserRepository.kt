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

fun getUserById(id: Int): UserDao? {
    return transaction {
        UserDao.findById(id)
    }
}

// TODO:
//fun getUserByUsername(username: String): UserDao? {
//    transaction {
//         // sql query? lub jest jakas metoda juz do tego bez potrzeby definiowania sqla? albo jakies query sie definiuje wg api?
//    }
//}

fun saveUserToDb(userDto: UserDto): User? {
    var user: User? = null
    transaction {
        user = UserDao.new {
            username = userDto.username
            password = userDto.password
            name = userDto.name
            surname = userDto.surname
        }.toUser()
        println("Added user " + user?.username) // TODO: fix this prints also when error, like users table doesn't exist
    }
    return user
}

fun updateUserInDb(userDto: UserDto) {
    requireNotNull(userDto.id)
    val userDao = getUserById(userDto.id)
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
    val userDao = getUserById(id)
    transaction {
        userDao?.delete()
    }
}