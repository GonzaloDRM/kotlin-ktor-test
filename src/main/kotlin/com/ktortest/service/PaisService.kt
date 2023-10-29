package com.ktortest.service

import com.ktortest.model.Pais
import com.ktortest.model.Paises
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class PaisService {

    fun getlist(): List<Pais> {
        val pais = Pais(nombre = "Argentina", codigo = "arg")
        val pais1 = Pais(nombre = "Brasil", codigo = "br")
        val pais2 = Pais(nombre = "Chile", codigo = "ch")
        val pais3 = Pais(nombre = "Uruguay", codigo = "ur")
        val pais4 = Pais(nombre = "Paraguay", codigo = "pr")
        val pais5 = Pais(nombre = "Bolivia", codigo = "bl")

        val list = ArrayList<Pais>()
        list.add(pais)
        list.add(pais1)
        list.add(pais2)
        list.add(pais3)
        list.add(pais4)
        list.add(pais5)

        return list
    }

    fun buscarTodosLosPaises(): List<Pais> {
        return transaction {
            Paises.selectAll().map {
                Pais(it[Paises.nombre], it[Paises.codigo])
            }
        }
    }

}