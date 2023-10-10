package com.example.introductions_to_algorithms.chapter1


/* 2.1-4
Consider the searching problem:
Input: A sequence of n numbers  stored in array  and a
value x.
Output: An index i such that x equals A[i] or the special value NIL if x does not
appear in A.
Write pseudocode for linear search, which scans through the array from beginning to end, looking for x. Using a loop invariant, prove that your algorithm is
correct. Make sure that your loop invariant fulûlls the three necessary properties. */

fun main(){
    var nums = arrayOf(31, 41, 59, 26, 41, 58)
    println( LinearSearch(nums,58))
}

fun LinearSearch(nums: Array<Int>, x: Int): String{
    for (i in  nums.indices){
       if (nums[i] == x){
           var result = "We find a " + x + ": in the position: " + i.toString()
           return result
       }
    }
    return "NIL"
}