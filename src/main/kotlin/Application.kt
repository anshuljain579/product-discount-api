package com.nexure

import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain
fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }

    configureDatabase()
    val productRepo = ProductRepositoryImpl()
    val discountRepo = DiscountRepositoryImpl()
    val productService = ProductService(productRepo, discountRepo)

    routing {
        productRoutes(productService)
    }
}



