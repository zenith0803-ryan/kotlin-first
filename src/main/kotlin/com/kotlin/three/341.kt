package com.kotlin.three

// 3.4.1 자바컬렉션 API확장

fun main(args: Array<String>){
    val strings: List<String> = listOf("first", "second", "fourteenth")
    println(strings.last())
    val numbers: Collection<Int> = setOf(1,14,2)
    println(numbers.max())
    // last, max는 모두 확장함수다.

}
