package com.example.db

import org.jetbrains.exposed.sql.Table

object Categories: Table(){
    val article = integer("article")
    val name = varchar("name",100)

    override val primaryKey = PrimaryKey(article)
}