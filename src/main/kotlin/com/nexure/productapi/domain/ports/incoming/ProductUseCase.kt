package com.nexure.com.nexure.productapi.domain.ports.incoming

import com.nexure.com.nexure.productapi.domain.model.Discount
import com.nexure.com.nexure.productapi.domain.model.Product

interface ProductUseCase {
    fun getProductByCountry(country: String): List<Product>
    fun applyDiscount(productId: String, discount: Discount): ApplyDiscountResult
}

enum class ApplyDiscountResult {
    SUCCESS,
    PRODUCT_NOT_FOUND,
    DISCOUNT_ALREADY_APPLIED
}