package com.nexure.com.nexure.productapi.domain.ports.outgoing

import com.nexure.com.nexure.productapi.domain.model.Product

interface ProductRepository {
    fun findByCountry(country: String): List<Product>
    fun findById(productId: String): Product?
}