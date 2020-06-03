package com.kotlin.three

// 3.5.1 문자열 나누기
// Java : String.split
// 점(.)으로는 문자열을 분리할수가 없다...
// 자바의 split는 빈배열을 반환한다. (.)는 모든 문자를 나타내는 정규식으로 해석된다.
// 코틀린은 자바 split대신 어러가지다른 조합의 파라미터를 받는 split확장함수를 제공

fun main(args: Array<String>){
    println("12.345-6.A".split("\\.|-".toRegex())) //toRegex 확장함수를 사용해 문자열을 정규식으로 변환

    println("12.345-6.A".split(".","-"))  //여러구분 문자열을 지정한다.
}