package com.nexure.productapi.domain.ports.outgoing

import com.nexure.productapi.domain.model.Product

interface ProductRepository {
    fun findByCountry(country: String): List<Product>
    fun findById(productId: String): Product?
}