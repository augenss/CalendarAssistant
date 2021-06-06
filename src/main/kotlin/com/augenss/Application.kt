package com.augenss

import com.augenss.persistence.connectToDb
import com.augenss.persistence.setupDb
import com.augenss.routes.registerCalendarEventRoutes
import com.augenss.routes.registerUserRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        json()
    }
    registerUserRoutes()
    registerCalendarEventRoutes()
    connectToDb("calendarassistant.db")
    setupDb()
}
