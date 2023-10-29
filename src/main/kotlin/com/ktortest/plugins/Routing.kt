package com.ktortest.plugins

import com.ktortest.service.PaisService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val paisService = PaisService()

fun Application.configureRouting() {
    routing {
        get("/") {
            var list = paisService.getlist()

            call.respondText(list.toString())
        }
    }

    routing {
        get("/paises") {
            val paises = paisService.buscarTodosLosPaises()
            call.respond(paises)
        }
    }
}
