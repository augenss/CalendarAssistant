package com.augenss

//import com.augenss.dao.DaoDatabaseFacade
//import com.augenss.dao.sqliteDb
import com.augenss.routes.registerUserRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(CallLogging)
    install(ContentNegotiation) {
        json()
    }
    registerUserRoutes()
//    val db = DaoDatabaseFacade(sqliteDb())
//    db.init() // this will be redundant when database in files
}
