val kotlin_version = "2.0.0"

plugins {
    kotlin("jvm") version "2.2.0"
    id("io.ktor.plugin") version "3.3.2"
    kotlin("plugin.serialization") version "2.2.20"
}

group = "com.nexure"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

dependencies {
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-netty")
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("io.ktor:ktor-server-config-yaml:3.3.2")
    implementation("io.ktor:ktor-server-core-jvm:3.3.2")
    implementation("io.ktor:ktor-server-content-negotiation:3.3.2")
    implementation("io.ktor:ktor-serialization-gson:3.3.2")
}