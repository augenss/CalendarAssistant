package com.augenss.persistence.repository

import com.augenss.dao.CalendarEventDao
import com.augenss.dao.CalendarEventsTable
import com.augenss.model.CalendarEvent
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime

fun createCalendarEventsTable() {
    transaction {
        SchemaUtils.create(CalendarEventsTable)
    }
}

fun addCalendarEventToDb(calendarEvent: CalendarEvent) {
    transaction {
        val calendarEventDao = CalendarEventDao.new {
            title = calendarEvent.title
            description = calendarEvent.description
            start = LocalDateTime.from(calendarEvent.start)
            end = LocalDateTime.from(calendarEvent.end)
            automaticallyScheduled = calendarEvent.automaticallyScheduled
        }
        println("Added event ${calendarEventDao.title}")
    }
}