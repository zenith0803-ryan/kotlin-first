package com.kotlin.three

/* 3.1 코틀린에서 컬렉션만들기 */
//https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/hash-set-of.html
val set = hashSetOf(1,7,53)

val list = arrayListOf(1,7,53)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
//to -- 언어가 제공하는 특별한 키워드가 아니라 일반함수

fun main (args : Array<String>){
    println(set.javaClass)  //javaClass는 자바 getClass()에 해당하는 코틀린코드
    println(list.javaClass)
    println(map.javaClass)
    // 이는 코틀린이 자바컬렉션을 활용하는것이다. Because 자바코드와 상호작용하기 훨씬 쉽기때문이다.
    // 즉, 코틀릭 컬렉션은 자바컬렉과 동일한 클래스 하지만 코틀린이 좀더 기능이 많다.
    val strings = listOf("first", "second", "foruteenth")
    println(strings.last())
    val numbers = setOf(1,14,2)
    println(numbers.max())
}
