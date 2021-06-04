package com.augenss.repository

import com.augenss.dto.UserDto
import com.augenss.persistence.repository.createUsersTable
import com.augenss.persistence.repository.getUserFromDb
import com.augenss.persistence.repository.saveUserToDb
import org.junit.Test

class UserRepoTest {

    @Test
    fun createUser() {
        // where to use mocks? i should need them here i guess
        val dbConnection: DbConnection = DbConnection()
        dbConnection.connectToH2()
        createUsersTable()
        // TODO: i want to be able to set id
        val userDto: UserDto = UserDto(1, "testusr", "pswrd", "Test U", "Surname")
        saveUserToDb(userDto)
        // select from and assert if that's the record we're expecting:
        val userDao = getUserFromDb(1)
        assert(userDto.toUser() == userDao?.toUser())
    }
}