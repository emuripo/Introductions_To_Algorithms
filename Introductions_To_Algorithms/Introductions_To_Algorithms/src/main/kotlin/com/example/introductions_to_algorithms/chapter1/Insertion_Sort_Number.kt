package com.esteban.introduction_algorithms.chapter1

import java.sql.DriverManager.println

/* Exercises chapter 1

2.1-1
Using Figure 2.2 as a model, illustrate the operation of INSERTION-SORT on an
array initially containing the sequence 31; 41; 59; 26; 41; 58.

2.1-2
Consider the procedure SUM-ARRAY on the facing page. It computes the sum of
the n numbers in array. State a loop invariant for this procedure, and use
its initialization, maintenance, and termination properties to show that the SUMARRAY procedure returns the sum of the numbers in AŒ1 W n�. */


fun main() {
println(NumberSort(numbers = arrayOf(31,41,59,26,41,58),6))
}


fun NumberSort(numbers: Array<Int> , size: Int): Int {
    var sum = 0
    for (i in 0 until size){
        sum= sum + numbers[i]
    }
return sum
}

