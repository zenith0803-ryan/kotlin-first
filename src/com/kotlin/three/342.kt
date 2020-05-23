package com.kotlin.three

// 3.4.2 가변인자함수 : 인자의 개수가 달라질수 있는 함수정의

fun main(args: Array<String>){
    val list = listOf(1,2,3)
    //public fun <T> listOf(vararg elements: T): List<T> = if (elements.size > 0) elements.asList() else emptyList()
    // 자바의 가변길이 인자 vararg : 메소드를 호출할때 원하는 개수만큼 값을 인자로 넘기면 자바 컴파일러가 배열에 그 값들을 넣어주는 기능
    //  자바 : 타입뒤에 ...를 붙임 , 코틀린 : 파라미터앞에  vararg 변경자를 붙인다.

    // 배열에 들어있는 원소를 가변길이 인자로 넘길때
    // 자바는  배열을 그냥넘기고, 코틀린 : 배열을 명시적으로 풀어서 배열의 각 원소가 인자로 전달되게 해야한다. - 스프레드연산자 - 배열앞에 *를 붙인다.
    val list2 = listOf("args: ", *args)  /// 스프레드 연산자가 배열의 내용을 펼쳐준다.
    println(list2)
}

