package com.kotlin.three

// 3.3.5 확장 프로퍼티
// 확장프로퍼티를 사용하면 기존 클래스 객체에 대한 프로퍼티 형식의 구문을 사용할수 있는 api를 추가할수 있다.

//3.7 확장 프로퍼티 선언하기
val String.lastChar  : Char
    get() = get(length - 1)

// 확장프로퍼티도 일반프로퍼티와 같은데 단지 수신객체클래스가 추가되었을 뿐이다.
// 뒷받침하는 필드가 없어서 기본 게터구현을 제공할수 없으므로 최소한 게터는 꼭 정의를 해야한다!


//3.8 변경 가능한 확장 프로퍼티 선언하기
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char){
        this.setCharAt(length-1, value)  //property setter
    }

fun main(args: Array<String>){
    println("Kotlin".lastChar )
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}
