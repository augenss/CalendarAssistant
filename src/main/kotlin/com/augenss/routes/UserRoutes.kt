package com.augenss.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getUsers() {
    get("/user") {
        call.respondText("List users to be implemented", status = HttpStatusCode.OK)
    }
}

fun Route.getUser() {
    get("/user") {
        call.respondText("Get user by id to be implemented", status = HttpStatusCode.OK)
    }
}

fun Route.createUser() {
    post("/user") {
        call.respondText("Create user to be implemented", status = HttpStatusCode.Accepted)
    }
}

fun Route.updateUser() {
    put("/user") {
        call.respondText("Update user to be implemented", status = HttpStatusCode.Accepted)
    }
}

fun Route.deleteUser() {
    delete("/user") {
        call.respondText("Delete user to be implemented", status = HttpStatusCode.Accepted)
    }
}

fun Application.registerUserRoutes() {
    routing {
        getUsers()
        getUser()
        createUser()
        updateUser()
        deleteUser()
    }
}