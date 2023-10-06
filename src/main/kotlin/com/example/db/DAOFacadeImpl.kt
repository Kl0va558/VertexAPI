package com.example.db

import com.example.models.Category
import com.example.models.Product
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

class DAOFacadeImpl : DAOFacade {

    private fun resultRowToProduct(row: ResultRow) = Product(
        id = row[Products.id],
        weight = row[Products.weight],
        image = row[Products.image].toString(),
        category_id = row[Products.category_id]!!.toInt(),
        name = row[Products.name],
        description = row[Products.description].toString(),
        article = row[Products.article].toString(),
        nmid = row[Products.nmid].toString()
    )

    private fun resultRowToCategory(row: ResultRow) = Category(
        article = row[Categories.article],
        name = row[Categories.name]
    )

    override suspend fun allProducts(): List<Product> = dbQuery {
        Products.selectAll().map(::resultRowToProduct)
    }

    override suspend fun product(category: String): List<Product> = dbQuery {
        val categoryExp: Category = Categories.select { Categories.name eq category }.map(::resultRowToCategory).single()
        Products
            .select { Products.category_id eq categoryExp.article}
            .map(::resultRowToProduct)
    }

    override suspend fun productId(id: Int): List<Product> = dbQuery {
        Products.select{Products.id eq id}.map(::resultRowToProduct)
    }

    override suspend fun productsWithNmId(): List<Product> = dbQuery{
        Products.select { Products.nmid neq  "#Н/Д" }.map (::resultRowToProduct)
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