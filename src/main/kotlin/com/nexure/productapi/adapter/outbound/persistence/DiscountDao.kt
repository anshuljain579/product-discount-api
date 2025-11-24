package com.nexure.com.nexure.productapi.adapter.outbound.persistence

import org.jetbrains.exposed.sql.Table

object DiscountDao : Table("discount") {
    val id = integer("id").autoIncrement()
    val productId = varchar("product_id", 50)
    val discountId = varchar("discount_id", 50)
    val percent = double("percent")
    override val primaryKey = PrimaryKey(id)

    init {
        uniqueIndex("uniq_pid_did", productId, discountId)
    }
}