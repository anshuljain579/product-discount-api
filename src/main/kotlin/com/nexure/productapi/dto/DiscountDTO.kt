package com.nexure.productapi.dto
import kotlinx.serialization.Serializable
@Serializable
data class DiscountDTO(
    val discountId: String,
    val percent: Double
)

fun DiscountDTO.toDomain() = Discount(discountId, percent)

fun Discount.toDiscountDTO = DiscountDTO(discountId, percent)