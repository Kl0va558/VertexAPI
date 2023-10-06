package com.example.routes

import com.example.db.DAOFacade
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.productRouting(dao: DAOFacade) {
    route("/products") {
        get {
            val category = call.parameters["category"] ?: return@get call.respond(dao.allProducts())
            call.respond(dao.product(category))
        }
    }

    route("/product"){
        get {
            call.respond(dao.productId(call.parameters["productId"]!!.toInt() ))
        }
    }

    route("/productsWithNmId"){
        get {
            call.respond(dao.productsWithNmId())
        }
    }
}