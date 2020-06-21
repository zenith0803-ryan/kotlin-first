package com.kotlin.two.two
//Kotlin에서 Person클래스사용하기

fun main(args : Array<String>){
    val person = Person("Bob")   // 뉴키워드가 없음
    println(person.name)  //property name을 직접사용 - 코틀린이 자동으로 게터호출


}
// 코틀린에서 자바클래스의 게터를 val property처럼 사용가능
// getter/setter쌍이 있는경우 var property처럼 사용가능
// 커스텀 getter(다른프로퍼티로부터 값을계산하는...)를 작성하면 그런 프로퍼티를 만들수있다.