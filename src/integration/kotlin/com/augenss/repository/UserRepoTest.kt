package com.augenss.repository

import com.augenss.dto.UserDto
import com.augenss.model.User
import com.augenss.persistence.repository.createUsersTable
import com.augenss.persistence.repository.getUserById
import com.augenss.persistence.repository.saveUserToDb
import com.augenss.persistence.repository.updateUserInDb
import org.junit.Test
import kotlin.test.assertNotNull

// runs tests from last to first?
// looks like it
// why?
// i read it should run sequentially from first to last test if haven't explicitly specified otherwise

// TODO: exclude common parts to @BeforeEach or @BeforeAll

// is there a tool to check for unused dependencies?

class UserRepoTest {
    private val testUserDto = UserDto(username = "testusr", password = "pswrd", name = "Test U", surname = "Surname") // TODO: move to a TestData class

    @Test
    fun shouldSaveToDbUserWithProvidedCredentials() {
        connectToH2()
        createUsersTable()
        val user: User? = saveUserToDb(testUserDto)
        assertNotNull(user)
        val userId = user.id?.raw
        assertNotNull(userId)
        val userDtoWithId = UserDto(userId, testUserDto.username, testUserDto.password, testUserDto.name, testUserDto.surname)
        assert(userDtoWithId.toUser() == user)
    }

    @Test
    fun shouldUpdateUsernameOfUserInDb() {
        connectToH2()
        createUsersTable()
        val user = saveUserToDb(testUserDto)
        assertNotNull(user)
        val userId = user.id?.raw
        assertNotNull(userId)
        val userDtoWithId = UserDto(userId, testUserDto.username, testUserDto.password, testUserDto.name, testUserDto.surname)
        assert(userDtoWithId.toUser() == user)
        val userDtoUpdated = UserDto(id = userId, username = "testusrUpdated", password = "pswrd", name = "Test U", surname = "Surname")
        updateUserInDb(userDtoUpdated)
        val userUpdated = getUserById(userId)?.toUser()
        assertNotNull(userUpdated)
        assert(userDtoUpdated.toUser() == userUpdated)
    }
}
