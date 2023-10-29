package com.ktortest.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Pais (val nombre:String, val codigo:String)

object Paises : Table(){
    val id = integer("id").autoIncrement()
    val nombre = varchar("nombre", 128)
    val codigo = varchar("codigo", 128)

    override val primaryKey = PrimaryKey(id)
}