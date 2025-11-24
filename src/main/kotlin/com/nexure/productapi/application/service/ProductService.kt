package com.nexure.productapi.application.service

import com.nexure.productapi.domain.model.Discount
import com.nexure.productapi.domain.model.Product
import com.nexure.productapi.domain.ports.incoming.ApplyDiscountResult
import com.nexure.productapi.domain.ports.incoming.ProductUseCase
import com.nexure.productapi.domain.ports.outgoing.DiscountRepository
import com.nexure.productapi.domain.ports.outgoing.ProductRepository

class ProductService(
    private val productRepository: ProductRepository,
    private val discountRepository: DiscountRepository
): ProductUseCase {

    override fun getProductByCountry(country: String): List<Product> {
        return productRepository.findByCountry(country).map {
            product -> product.copy(
                discounts = discountRepository.findByProductId(productId = product.id)
            )
        }
    }

    override fun applyDiscount(productId: String, discount: Discount): ApplyDiscountResult {
        val product = productRepository.findById(productId) ?: return ApplyDiscountResult.PRODUCT_NOT_FOUND

        if(discountRepository.isDiscountApplied(productId, discount.discountId)) {
            return ApplyDiscountResult.DISCOUNT_ALREADY_APPLIED
        }

        discountRepository.addDiscount(productId, discount)
        return ApplyDiscountResult.SUCCESS
    }
}