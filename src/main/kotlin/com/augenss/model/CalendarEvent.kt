package com.augenss.model

import java.time.ZonedDateTime

data class CalendarEvent(
        val id: CalendarEventId?,
        val title: String,
        val description: String?,
        val start: ZonedDateTime,
        val end: ZonedDateTime,
        val automaticallyScheduled: Boolean
        // + val suggestions
)

data class CalendarEventId(val raw: Int)