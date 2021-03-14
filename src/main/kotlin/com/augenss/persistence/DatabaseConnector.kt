package com.augenss.persistence

import com.augenss.model.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun connectToDb() {
    Database.connect("jdbc:sqlite:database/data.db", "org.sqlite.JDBC") // TODO: datasource to enable connection pooling
}

fun createDbTables() {
    transaction {
        SchemaUtils.create(Users)
    }
}