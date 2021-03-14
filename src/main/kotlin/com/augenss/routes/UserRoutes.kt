package com.augenss.routes

import com.augenss.model.User
import com.augenss.persistence.saveUserToDb
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.createOrUpdateUser() {
    put("/createOrUpdateUser") {
        val user = call.receive<User>()
        saveUserToDb(user)
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
        createOrUpdateUser()
        getUsers()
    }
}