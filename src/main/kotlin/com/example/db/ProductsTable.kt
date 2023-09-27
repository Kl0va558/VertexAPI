package com.example.db

import org.jetbrains.exposed.sql.Table

object Products : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 120)
    val weight = integer("weight").nullable()
    val image = varchar("image",200).nullable()
    val category_id = integer("category_id").references(Categories.article)
    val description = varchar("description",3000).nullable()

    override val primaryKey = PrimaryKey(id)
}