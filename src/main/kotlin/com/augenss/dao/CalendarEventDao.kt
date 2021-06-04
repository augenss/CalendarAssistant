package com.augenss.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.`java-time`.datetime

class CalendarEventDao(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<CalendarEventDao>(UsersTable)
    var title by CalendarEventsTable.title
    var description by CalendarEventsTable.description
    var start by CalendarEventsTable.start
    var end by CalendarEventsTable.end
    var automaticallyScheduled by CalendarEventsTable.automaticallyScheduled
}
object CalendarEventsTable: IntIdTable() {
    val title = varchar("title", 50)
    val description = varchar("description", 200).nullable()
    val start = datetime("event_start")
    val end = datetime("event_end")
    val automaticallyScheduled = bool("automatically_scheduled")
}