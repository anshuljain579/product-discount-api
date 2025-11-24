package com.nexure.productapi.domain.ports.outgoing

import com.nexure.productapi.domain.model.Discount

interface DiscountRepository {
    fun findByProductId(productId: String): List<Discount>
    fun isDiscountApplied(productId: String, discountId: String): Boolean
    fun addDiscount(productId: String, discount: Discount): Boolean
}