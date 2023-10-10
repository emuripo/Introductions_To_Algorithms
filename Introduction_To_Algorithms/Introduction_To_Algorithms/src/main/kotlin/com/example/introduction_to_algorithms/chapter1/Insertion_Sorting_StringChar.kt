package com.esteban.introduction_algorithms.chapter1//Objetivo: Dado una cadena s, encuentra la longitud de la subcadena más larga sin caracteres repetidos.
//
//Entradas:
//
//Una cadena s de longitud n (1 ≤ n ≤ 10^5).
//Salidas:
//
//Un entero que representa la longitud de la subcadena más larga sin caracteres repetidos.


//Ejemplo:

//Si s = "abcabcbb", la respuesta es 3 porque la subcadena más larga sin caracteres repetidos es "abc".
//
//Restricciones:
//
//La cadena puede contener cualquier carácter ASCII imprimible.
//Si la cadena está vacía, la respuesta es 0.




fun main() {
    println(Subcadena("abcabcbb"))  // Debería imprimir 3
}

fun Subcadena(s: String): Int {
    val n = s.length
    var ans = 0
    val map = mutableMapOf<Char, Int>()  // Para almacenar la última posición en la que vimos cada caracter

    var i = 0  // Inicio de la ventana
    for (j in 0 until n) {  // j es el final de la ventana
        if (map.containsKey(s[j])) { // Si el caracter ya está en el mapa, movemos el inicio de la ventana justo después de la última ocurrencia
            i = maxOf(i, map[s[j]]!! + 1)
        }
        ans = maxOf(ans, j - i + 1)  // Actualizamos la respuesta
        map[s[j]] = j  // Actualizamos la última posición del caracter
    }
    return ans
}


