package com.nexure.productapi.domain.model

import java.util.Collections.emptyList

data class Product(
    val id: String,
    val name: String,
    val basePrice: Double,
    val country: String,
    val discounts: List<Discount> = emptyList()
)
