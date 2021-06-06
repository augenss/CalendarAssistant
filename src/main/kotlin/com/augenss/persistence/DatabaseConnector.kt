package com.augenss.persistence

import com.augenss.persistence.repository.createCalendarEventsTable
import com.augenss.persistence.repository.createUsersTable
import org.jetbrains.exposed.sql.Database
import java.sql.DriverManager

fun connectToDb(filename: String) { // TODO: make it configurable, so it's testable
    val url = "jdbc:sqlite:database/$filename"
    Database.connect({DriverManager.getConnection(url)})
}

fun setupDb() {
    createUsersTable()
    createCalendarEventsTable()
}