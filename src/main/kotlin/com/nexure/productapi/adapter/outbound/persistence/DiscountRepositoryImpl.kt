package com.nexure.com.nexure.productapi.adapter.outbound.persistence

import com.nexure.productapi.domain.model.Discount
import com.nexure.productapi.domain.ports.outgoing.DiscountRepository
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insertIgnore
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class DiscountRepositoryImpl : DiscountRepository {
    override fun findByProductId(productId: String): List<Discount> = transaction {
        DiscountDao.select { DiscountDao.productId eq productId }
            .map {
                Discount(it[DiscountDao.discountId], it[DiscountDao.percent])
            }
    }

    override fun isDiscountApplied(productId: String, discountId: String): Boolean = transaction {
        DiscountDao.select {
            (DiscountDao.productId eq productId) and (DiscountDao.discountId eq discountId)
        }.count() > 0

    }

    override fun addDiscount(productId: String, discount: Discount): Boolean = transaction {
        val insertResult = DiscountDao.insertIgnore {
            it[DiscountDao.productId] = productId
            it[discountId] = discount.discountId
            it[percent] = discount.percent
        }

        insertResult.insertedCount > 0
    }
}