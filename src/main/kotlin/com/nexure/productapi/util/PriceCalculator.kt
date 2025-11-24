package com.nexure.com.nexure.productapi.util

object PriceCalculator {
    private val valRules = mapOf("Sweden" to 0.25, "Germany" to 0.19, "France" to 0.20)

    fun calculatePrice(basePrice: Double, discounts: List<Double>, country: String): Double {
        val discountFactor = discounts.fold(1.0) {acc, pct -> acc * (1 - pct / 100) }
        val vat = valRules[country] ?: 0.0
        val discounted = basePrice * discountFactor
        return discounted * (1.0 + vat)
    }
}