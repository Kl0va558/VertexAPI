package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val name: String, val id: Int, val weight: Int, val article: Int, val image: String,
    val category: String
)