package com.nexure.productapi.dto

import kotlinx.serialization.Serializable
@Serializable
data class ProductDTO(
    val id: String,
    val name: String,
    val basePrice: Double,
    val country: String,
    val discounts: List<DiscountDTO>,
    val finalPrice: Double
)

fun Product.toProductDTO(finalPriceCalculator: (Double, List<Double>, String) -> Double): ProductDTO =
    ProductDTO(
        id,
        name,
        basePrice,
        country,
        discounts.map { it.toDiscountDTO() },
        finalPriceCalculator(basePrice, discounts.map { it.percent }, country )
    )