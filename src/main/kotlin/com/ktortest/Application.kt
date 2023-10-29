package com.ktortest

import com.ktortest.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
    Database.connect("jdbc:mysql://localhost:3306/testkotlin", driver = "com.mysql.cj.jdbc.Driver", user = "gonza", password = "root")
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}
