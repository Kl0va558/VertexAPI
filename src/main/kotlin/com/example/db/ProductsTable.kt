package com.example.db

import org.jetbrains.exposed.sql.Table

object Products : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 120)
    val weight = integer("weight").nullable()
    val image = varchar("image",200).nullable()
    val category_id = integer("category_id").references(Categories.article).nullable()
    val description = varchar("description",3000).nullable()
    val article = varchar("article",200).nullable()
    val nmid = varchar("nmid",200).nullable()

    override val primaryKey = PrimaryKey(id)
}