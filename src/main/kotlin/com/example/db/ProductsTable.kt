package com.example.db

import org.jetbrains.exposed.sql.Table

object Products : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 120)
    val weight = integer("weight")
    val image = varchar("image",200)
    val article = integer("article")
    val category = varchar("category",70)

    override val primaryKey = PrimaryKey(id)
}