package com.esteban.introduction_algorithms.chapter1

import java.sql.DriverManager.println

/*
2.1-3
Rewrite the INSERTION-SORT procedure to sort into monotonically decreasing instead of monotonically increasing order.
*/

fun main(){
    var nums = arrayOf(5, 2, 4, 6, 1, 3)
    var list = SortDecreasing(nums)
    ArrayPrinted(list)

}

fun SortDecreasing(nums: Array<Int>): Array<Int> {

   for (i in 1 until nums.size){
       var key =  nums[i]
       var j = i-1
       while (j >0 && nums[j] < key){
           nums[j+1] = nums[j]
           j--
       }
       nums[j+1] = key
   }
    return nums
}

var ArrayPrinted = {nums: Array<Int> ->
    println(nums.joinToString(", "))
}