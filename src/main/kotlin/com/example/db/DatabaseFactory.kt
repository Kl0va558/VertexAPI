package com.example.db

import com.example.models.Product
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction


object DatabaseFactory{
    fun init() {
        val database = Database.connect(
            "jdbc:postgresql://localhost:5432/VertexTest", driver = "org.postgresql.Driver",
            user = "postgres", password = "V783278k"
        )
        transaction(database) {

        }
    }
}
suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }