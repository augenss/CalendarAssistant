package com.augenss.dao

import org.jetbrains.exposed.sql.Database

fun sqliteDb(): Database {
    return Database.connect("jdbc:sqlite:database/data.db", "org.sqlite.JDBC") // TODO: datasource to enable connection pooling
}

