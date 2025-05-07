package com.example.introkotlin.TemasKotlin

/*
List
MutableList
Set
MutableSet
Map
MutableMap
*/

fun main() {

    var figura: mutableFiguras = mutableListOf("cuadrado", "triangulo", "circulo")
    val readOnlyFiguras = listOf("cuadrado", "triangulo", "circulo")
    val mutableFiguras: List<String> = figura

    val frutas = setOf("manzana", "banana", "naranja")
    val mutableFrutas = mutableSetOf("manzana", "banana", "naranja")

    val coches = mapOf("uno" to 1, "dos" to 2, "tres" to 3)
    println(coches)
    val mutableCoches = mutableMapOf("uno" to 1, "dos" to 2, "tres" to 3)
    println(mutableCoches)


}