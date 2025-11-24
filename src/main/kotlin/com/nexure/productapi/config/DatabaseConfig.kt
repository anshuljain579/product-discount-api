package com.nexure.com.nexure.productapi.config
import io.ktor.server.application.Application
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabase() {
    val url = environment.config.property("ktor.database.url").getString()
    val driver = environment.config.property("ktor.database.driver").getString()
    val username = environment.config.property("ktor.database.username").getString()
    val password = environment.config.property("ktor.database.password").getString()

    Database.connect(url = url, driver = driver, username = username, password = passord)
}