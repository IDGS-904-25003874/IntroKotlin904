package com.example.introkotlin.TemasKotlin


fun main(){
    do {
        println("De cuantas filas desea hacer la piramide? (0 para salir)")
        var opcion = readln().toInt()
        if (opcion > 0) {
            var fila = 1
            do {
                var columna = 1
                do {
                    print("*")
                    columna++
                } while (columna <= fila)
                println()
                fila++
            } while (fila <= opcion)
        }
    } while (opcion != 0)
}
