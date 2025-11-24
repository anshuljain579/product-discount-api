package com.nexure.com.nexure.productapi.adapter.outbound.persistence

import org.jetbrains.exposed.sql.Table

object ProductDao: Table("product") {
    val id = varchar("id", 50)
    val name = varchar("name", 255)
    val basePrice = double("base_price")
    val country = varchar("country", 255)

    override val primaryKey = PrimaryKey(id)
}