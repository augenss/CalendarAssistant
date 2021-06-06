package com.augenss.dao

import com.augenss.model.User
import com.augenss.model.UserId
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

class UserDao(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<UserDao>(UsersTable)
    var username by UsersTable.username
    var password by UsersTable.password
    var name by UsersTable.name
    var surname by UsersTable.surname

    fun toUser() = User(UserId(id.value), username, password, name, surname)
}

object UsersTable: IntIdTable() {
    val username = varchar("username", 50)
    val password = varchar("password", 50)
    val name = varchar("name", 50)
    val surname = varchar("surname", 50).nullable()
}
