package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val name: String, val id: Int, val weight: Int?, val image: String, val description: String,
    val category_id: Int
)