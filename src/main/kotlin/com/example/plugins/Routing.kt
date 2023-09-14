package com.example.plugins

import com.example.db.DAOFacade
import com.example.routes.productRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(dao: DAOFacade) {
    routing {
        productRouting(dao)
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
