package com.kotlin.two.one

fun main(args: Array<String>){
    val name = if ( args.size > 0) args[0] else "Kotlin"
    println("Hello, $name")
    println("\$name")  //$문자를 넣고싶을대 백슬랙시를 문자앞에 넣는다.
    if(args.size > 0)
        println("Hello, ${args[0]}")  //args배열의 첫번째 원소를 넣기
}

//문자열 템플릿(string template)
//문자열리터럴의 필요한곳에 변수를 넣고 변수앞에 $를 추가
// 간결하다.
//