package com.nexure.com.nexure.productapi.adapter.outbound.persistence

import com.nexure.productapi.domain.model.Product
import com.nexure.productapi.domain.ports.outgoing.ProductRepository
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class ProductRepositoryImpl: ProductRepository {
    override fun findByCountry(country: String): List<Product> = transaction {
        ProductDao.select { ProductDao.country eq country }.map {
            Product(
                id = it[ProductDao.id],
                name = it[ProductDao.name],
                basePrice = it[ProductDao.basePrice],
                country = it[ProductDao.country]
            )
        }
    }

    override fun findById(productId: String): Product? = transaction {
        ProductDao.select { ProductDao.id eq productId }.mapNotNull {
            Product(
                id = it[ProductDao.id],
                name = it[ProductDao.name],
                basePrice = it[ProductDao.basePrice],
                country = it[ProductDao.country]
            )
        }.singleOrNull()
    }
}