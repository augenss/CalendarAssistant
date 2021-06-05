package com.augenss.routes

import com.augenss.dto.CalendarEventDto
import com.augenss.persistence.repository.addCalendarEventToDb
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.registerCalendarEventRoutes() {
    routing {
        getCalendarEvents()
        getCalendarEvent()
        addManuallyScheduledCalendarEvent()
        updateCalendarEvent()
        deleteCalendarEvent()
    }
}

fun Route.getCalendarEvents() {
    get("/calendar-events") {
    }
}

fun Route.getCalendarEvent() {
    get("/calendar-events/{id}") {

    }
}

// TODO: when two endpoints have the same http method but different dto passed in body, can they have the same url ?
fun Route.addManuallyScheduledCalendarEvent() {
    post("/calendar-events") {
        val calendarEventDto = call.receive<CalendarEventDto>()
        com.augenss.service.addManuallyScheduledCalendarEvent(calendarEventDto)
        call.respondText("Event ${calendarEventDto.title} created", status = HttpStatusCode.Created)
    }
}

fun Route.addCalendarEventForAutomaticSchedule() {
    post("/calendar-events") {

    }
}

fun Route.updateCalendarEvent() {
    put("/calendar-events") {

    }
}

fun Route.deleteCalendarEvent() {
    delete("/calendar-events") {

    }
}
