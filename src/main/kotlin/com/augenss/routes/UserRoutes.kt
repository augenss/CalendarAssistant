package com.augenss.routes

import com.augenss.dto.UserDto
import com.augenss.persistence.deleteUserFromDb
import com.augenss.persistence.getUsersFromDb
import com.augenss.persistence.saveUserToDb
import com.augenss.persistence.updateUserInDb
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.registerUserRoutes() {
    routing {
        getUsers()
        getUser()
        createUser()
        updateUser()
        deleteUser()
    }
}

fun Route.getUsers() {
    get("/user") {
        val users = getUsersFromDb().map { it.toUserDto() }
        call.respond(users)
    }
}

fun Route.getUser() {
    get("/user/{id}") {
        call.respondText("Get user by id to be implemented", status = HttpStatusCode.OK)
    }
}

fun Route.createUser() {
    post("/user") {
        val userDto = call.receive<UserDto>()
        saveUserToDb(userDto)
        call.respondText("User ${userDto.username} created", status = HttpStatusCode.Accepted)
    }
}

fun Route.updateUser() {
    put("/user") {
        val userDto = call.receive<UserDto>()
        updateUserInDb(userDto)
        call.respondText("User ${userDto.username} updated", status = HttpStatusCode.OK)
    }
}

fun Route.deleteUser() {
    delete("/user") {
        val userId = call.receive<Int>()
        deleteUserFromDb(userId)
        call.respondText("User deleted", status = HttpStatusCode.OK)
    }
}
