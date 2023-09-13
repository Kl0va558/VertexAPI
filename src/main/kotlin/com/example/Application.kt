package com.example

import com.example.db.DAOFacade
import com.example.db.DAOFacadeImpl
import com.example.db.DatabaseFactory
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()
    configureSerialization()
    val dao = DAOFacadeImpl ()
    configureRouting(dao)
}
