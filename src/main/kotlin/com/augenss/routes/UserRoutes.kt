package com.augenss.routes

import com.augenss.dto.UserDto
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.createUser() {
    post("/createUser") {
        val user = call.receive<UserDto>()
//        saveUserToDb(user)
        call.respondText("Customer stored correctly", status = HttpStatusCode.Accepted)
    }
}

fun Route.getUsers() {
    get("/users") {
        call.respondText("users")
    }
}

fun Application.registerUserRoutes() {
    routing {
        createUser()
        getUsers()
    }
}