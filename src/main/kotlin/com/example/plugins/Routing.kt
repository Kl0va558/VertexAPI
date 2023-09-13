package com.example.plugins

import com.example.db.DAOFacade
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(dao: DAOFacade) {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/products"){
            val products = dao.allProducts()
            call.respond(products)
        }
    }
}
