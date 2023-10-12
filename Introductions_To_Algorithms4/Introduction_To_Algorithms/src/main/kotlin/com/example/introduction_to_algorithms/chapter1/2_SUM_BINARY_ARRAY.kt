package com.example.introductions_to_algorithms.chapter1

/* "Consider the problem of adding two n-bit binary integers a and b, stored in two n-element arrays A[0..n-1] and B[0..n-1]
where each element is either 0 or 1, a = Σ(from i=0 to n-1) A[i] * 2^i, and b = Σ(from i=0 to n-1) B[i] * 2^i.
The sum c = a + b of the two integers should be stored in binary form in an (n + 1)-element array C[0..n],
where c = Σ(from i=0 to n) C[i] * 2^i.
Write a procedure ADD-BINARY-INTEGERS that takes as input arrays A and B, along with the length n, and returns array C holding the sum." */


fun main (){
var arrayA = byteArrayOf(0,1,1)
var arrayB = byteArrayOf(1,0,1)
var result = addBinaryIntegers(arrayA,arrayB)
println(result.joinToString(", "))
}

fun addBinaryIntegers (arrayA: ByteArray, arrayB: ByteArray): ByteArray {
    var lgth = arrayA.size
    var arrayC = ByteArray(lgth + 1)
    var carry = 0

    for (i in lgth - 1 downTo 0){
        var sum = arrayA[i] + arrayB[i] + carry
        arrayC[i + 1] = (sum % 2).toByte()
        carry = sum / 2
    }
    arrayC[0] = carry.toByte()
    return arrayC
}

/*
val n = A.size: Here we simply store the size of the array A (which we assume is the same size as B) into a variable n for clarity in the code.

val C = ByteArray(n + 1): We create a new array C that will be the result of the sum. The reason it has n + 1 elements is because, in the worst-case scenario, the sum can generate an additional carry that might need extra space.

var carry = 0: We initialize the carry variable. This variable will hold any number carried over when summing individual digits of the arrays.

for (i in n - 1 downTo 0): We begin a loop that goes from the last index of the arrays (which is n-1 because indices start at 0) down to the first (0). We are iterating in reverse because binary summation is done from right to left (from the least significant bit to the most significant bit).

val sum = A[i] + B[i] + carry: We sum the bits at position i from arrays A and B and add any existing carry.

C[i + 1] = (sum % 2).toByte(): Here we store the result bit in array C. If sum is 2 (meaning a 1 from A, a 1 from B, and a 0 from carry), then sum % 2 will be 0, which is what we want to store at that position. If sum is 3 (a 1 from A, a 1 from B, and a 1 from carry), sum % 2 will also be 1.

carry = sum / 2: Here we update the carry variable. If sum is 2 or 3, the carry will be 1; otherwise, it will be 0.

C[0] = carry.toByte(): Once the loop has finished, the final carry is stored in the first position of C.

return C: Finally, we return the resulting C array
*/