package com.augenss.dto

import com.augenss.serializers.KZonedDateTimeSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.ZonedDateTime

@Serializable
data class CalendarEventForAutomaticScheduleDto(
    val title: String,
    val description: String?,
    val durationInMinutes: Int,
    @Serializable(KZonedDateTimeSerializer::class)
    val minStart: ZonedDateTime? = ZonedDateTime.now()
)
{
    // TODO:
//    fun toCalendarEvent(): CalendarEvent {
//
//    }
}