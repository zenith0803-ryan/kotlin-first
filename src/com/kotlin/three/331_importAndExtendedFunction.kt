package com.kotlin.three

// 3.3.1 임포트와 확장함수
// 확장함수를 사용하려면 import해야한다.

import strings.lastChar
import strings.*
import strings.lastChar as last // 이름을 변경해서 가져오면 이름 충돌을 막을수 있다.
//코틀린문법상 확장함수는 반드시 짧은 이름을 써야한다.


val c = "Kotlin".lastChar()

val d = "Kotlin".lastChar2()

val e = "Kotlin".last()

fun main(args : Array<String>){
    println(c)
    println(d)
    println(e)

}


