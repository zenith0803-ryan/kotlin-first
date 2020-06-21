package com.kotlin.two.four

import java.util.*

// 2.4.1 while loop
// while, do-while 은 자바와 동일


// 2.4.2 수에 대한 이터레이션: 범위와 수열
val oneToTen = 1..10  //폐구간 또는 양끝을 포함하는구간
//어떤 범위에 속한값을 일정한 순서로 이터레이션하는 경우를 수열이라고 부른다.

fun fizzBuzz(i: Int) = when{
    i % 15 == 0 -> "FIzzBuzz"
    i % 3 == 0 -> "FIzz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}




fun main(args: Array<String>){
    for(i in 1..30)
        print(fizzBuzz(i))
    println()
    for( i in 30 downTo 1 step 2){
        print(fizzBuzz(i))
    }
    println()

    //2.4.3 맵에대한 이터레이션
    // 맵을 초기화하고 이터레이션하기
    val binaryReps = TreeMap<Char, String >()
    for( c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
        // in JavaCode
        //binaryReps.put(c, binary)

    }
    for( (letter, binary)in binaryReps){
        println("$letter = $binary")
    }
    val list = arrayListOf("10", "11", "12")
    for((index, element) in list.withIndex()){ // index와 함께 컬렉션을 이터레이션한다.
        println("$index: $element")
    }

    println("2.4.4 in으로 컬렉션이나 범위의 원소검사")
    println(" 2.25 in을 사용해 값이 범위에 속하는지 검사하기")
    fun isLetter(c: Char)  = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c: Char) = c !in '0'..'9'
    println(isLetter('q'))
    println(isNotDigit('x'))
    println("2.26 when에서 in사용하기")
    fun recognize(c:Char) = when(c){
        in '0'..'9' -> "It is a digit!"
        in 'a'..'z' -> "It is a letter"
        else -> "I don't know"
    }
    println(recognize('1'))
    println(recognize('a'))
    println(recognize(':'))

    //범위는 문자뿐만아니라 비교가능한 클래스(Comparable interface 구현한..)라면 그 클래스의 인스턴스 객체를 사용해 범위를 만들수 있다.
    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in setOf("Java","Scala"))


}

