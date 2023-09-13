package com.example.db

import com.example.models.Product


interface DAOFacade {
    suspend fun allProducts(): List<Product>
    suspend fun product(id: Int): Product?
    suspend fun addNewProduct(name: String): Product?
    suspend fun editProduct(id: Int, name: String): Boolean
    suspend fun deleteProduct(id: Int): Boolean
}