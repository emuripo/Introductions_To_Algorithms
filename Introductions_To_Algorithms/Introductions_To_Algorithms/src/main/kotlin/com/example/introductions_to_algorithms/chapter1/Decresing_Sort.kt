package com.example.introductions_to_algorithms.chapter1

fun main() {
    var nums = arrayOf(5, 2, 4, 6, 1, 3)
    var list = SortDecreasing(nums)
    ArrayPrinted(list)
}

fun SortDecreasing(nums: Array<Int>): Array<Int> {
    for (i in 1 until nums.size) {
        val key = nums[i]
        var j = i - 1
        while (j >= 0 && nums[j] < key) {
            nums[j + 1] = nums[j]
            j--
        }
        nums[j + 1] = key // Asegurarse de que, cuando j = -1, se traduce en nums[0] = key
    }
    return nums
}

val ArrayPrinted = { nums: Array<Int> ->
    println(nums.joinToString(", "))
}
