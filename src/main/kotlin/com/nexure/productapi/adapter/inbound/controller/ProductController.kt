package com.nexure.productapi.adapter.inbound.controller

import com.nexure.productapi.domain.ports.incoming.ApplyDiscountResult
import com.nexure.productapi.domain.ports.incoming.ProductUseCase
import com.nexure.productapi.dto.DiscountDTO
import com.nexure.productapi.util.PriceCalculator


fun Route.productRoutes(productUseCase: ProductUseCase) {

    get("/products") {
        val country = call.request.queryParameters["country"]

        if(country == null) {
            call.respond(HttpStatusCodes.BadRequest, "Missing country parameter")
            return@get
        }

        val products = productUseCase.getProductByCountry(country)
        val dtos = products.map{
            it.toProductDTO(PriceCalculator::calculatorFinalPrice)
        }

        call.respond(HttpStatusCode.OK, dtos)
    }

    put("/products/{id}/discount") {
        val productId = call.parameters["id"]
        if(productId == null) {
            call.respond(HttpStatusCode.BadRequest, "Missing Product Id in path")
            return@put
        }

        val discountRequest = call.receive<DiscountDTO>()
        val result = productUseCase.applyDiscount(productId = productId, discountRequest.toDomain())

        when(result) {
            ApplyDiscountResult.SUCCESS -> call.respond(HttpStatusCodes.Created)
            ApplyDiscountResult.PRODUCT_NOT_FOUND -> call.respond(HttpStatusCodes.NotFound, "Product not Found")
            ApplyDiscountResult.DISCOUNT_ALREADY_APPLIED -> call.respond(HttpStatusCodes.OK, "Discount already applied to this product")
        }
    }
}