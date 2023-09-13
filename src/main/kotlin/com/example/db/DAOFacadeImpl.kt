package com.example.db

import com.example.models.Product
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll

class DAOFacadeImpl : DAOFacade {

    private fun resultRowToProduct(row: ResultRow) = Product(
        name = row[Products.name]
    )

    override suspend fun allProducts(): List<Product> = dbQuery{
        Products.selectAll().map(::resultRowToProduct)
    }

    override suspend fun product(id: Int): Product? {
        TODO("Not yet implemented")
    }

    override suspend fun addNewProduct(name: String): Product? {
        TODO("Not yet implemented")
    }

    override suspend fun editProduct(id: Int, name: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}