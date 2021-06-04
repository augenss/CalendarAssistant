package com.augenss.service

import com.augenss.dto.CalendarEventDto
import com.augenss.dto.CalendarEventForAutomaticScheduleDto
import com.augenss.persistence.repository.addCalendarEventToDb

fun scheduleCalendarEvent(calendarEventForAutomaticScheduleDto: CalendarEventForAutomaticScheduleDto) {

}

fun addManuallyScheduledCalendarEvent(calendarEventDto: CalendarEventDto) {
    addCalendarEventToDb(calendarEventDto.toCalendarEvent())
}