package com.example.introkotlin.TemasKotlin

fun main(){
    //variables solo lectura val
    //variables mutables var
    val a=4
    val b=8
    var c=10

    println(a)
    println("el valor de b es $b")
    println("el valor de c + 2 es ${c+2}")

    c= a+2
    c+=8
    c-=5
    c*8
    c/=2
    println("el valor de c es $c")
    /*
    val num1:int=23
    var num2:int=12

    num2=6

    var nombre:String="Cesar"
    var caracter:Char='a'

    var num4:Float=12.5f
    var num5:Double=12.5

*/
}
