package com.example.introkotlin.TemasKotlin

fun sumar(a:Int, b:Int)= a+b
fun restar(a: Int, b: Int)= a-b
fun multiplicar(a: Int,b: Int)=a*b
fun dividir(a: Int,b: Int)=a/b

fun main(){
    while(true){
        println("Que operacion desea realizar?")
        println("1: Sumar")
        println("2: Restar")
        println("3: Multiplicar")
        println("4: Dividir")
        println("5: Terminar el programa")
        var opcion = readln().toInt()

        var num1 = 0
        var num2 = 0

        when(opcion) {
            1 -> {
                println("Ingrese el primer numero:")
                num1 = readln().toInt()
                println("Ingrese el segundo numero:")
                num2 = readln().toInt()
                println("La suma de $num1 + $num2 es: ${sumar(num1, num2)}\n")
                num1 = 0
                num2 = 0
            }

            2 -> {
                println("Ingrese el primer numero:")
                num1 = readln().toInt()
                println("Ingrese el segundo numero:")
                num2 = readln().toInt()
                println("La resta de $num1 - $num2 es: ${restar(num1, num2)}\n")
                num1 = 0
                num2 = 0
            }

            3 -> {
                println("Ingrese el primer numero:")
                num1 = readln().toInt()
                println("Ingrese el segundo numero:")
                num2 = readln().toInt()
                println("La multiplicacion de $num1 * $num2 es: ${multiplicar(num1, num2)}\n")
                num1 = 0
                num2 = 0
            }

            4 -> {
                println("Ingrese el primer numero:")
                num1 = readln().toInt()
                println("Ingresa el segundo numero:")
                num2 = readln().toInt()
                if (num2 != 0) {
                    println("La division de $num1 entre $num2 es: ${dividir(num1, num2)}\n")
                }
                else {
                    println("No se puede dividir entre 0")
                }
            }

            5 -> {
                println("Saliendo del programa...")
                break
            }

            else -> {
                println("Opcion no valida")
            }
        }
    }
}

