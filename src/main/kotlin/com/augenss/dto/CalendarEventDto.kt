package com.augenss.dto

import com.augenss.model.CalendarEvent
import com.augenss.model.CalendarEventId
import com.augenss.serializers.KZonedDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.ZonedDateTime

@Serializable
class CalendarEventDto (
        val id: Int?,
        val title: String,
        val description: String?,
        @Serializable(KZonedDateTimeSerializer::class)
        val start: ZonedDateTime,
        @Serializable(KZonedDateTimeSerializer::class)
        val end: ZonedDateTime
)
{
        fun toCalendarEvent(): CalendarEvent = when(id) {
                null -> CalendarEvent(id = null, title = title, description = description, start = ZonedDateTime.from(start), end = ZonedDateTime.from(end), automaticallyScheduled = false)
                else -> CalendarEvent(id = CalendarEventId(id), title = title, description = description, start = ZonedDateTime.from(start), end = ZonedDateTime.from(end), automaticallyScheduled = false)
        }
}
