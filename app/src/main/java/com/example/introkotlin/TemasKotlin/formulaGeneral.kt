package com.example.introkotlin.TemasKotlin
import kotlin.math.sqrt

fun calcularDiscriminante(a: Int, b: Int, c: Int): Double {
    return (calcularCuadrado(b) - (4 * a * c)).toDouble()
}

fun calcularCuadrado(numero: Int): Int {
    return numero * numero
}

fun calcularFormulaPositiva(a: Int, b: Int, c: Int): Double {
    return (-b + sqrt(calcularDiscriminante(a, b, c)))/(2*a)
}

fun calcularFormulaNegativa(a: Int, b: Int, c: Int): Double {
    return (-b - sqrt(calcularDiscriminante(a, b, c)))/(2*a)
}

fun main() {
    while (true) {
        println("Ingrese el valor de a")
        val a = readln().toInt()
        if (a == 0) {
            println("El valor de 'a' no puede ser cero. La ecuacion no seria cuadratica.")
            continue
        }

        println("Ingrese el valor de b")
        val b = readln().toInt()

        println("Ingrese el valor de c")
        val c = readln().toInt()

        val discriminante = calcularDiscriminante(a, b, c)

        if (discriminante < 0) {
            println("La ecuación no tiene soluciones reales (discriminante negativo: $discriminante)")
            continue
        }

        val resultadoP = calcularFormulaPositiva(a, b, c)
        val resultadoN = calcularFormulaNegativa(a, b, c)

        println("El resultado positivo es: $resultadoP")
        println("El resultado negativo es: $resultadoN")

        println("¿Desea calcular otra ecuación? (s/n)")
        val respuesta = readln()
        if (respuesta != "s") {
            break
        }
    }
}