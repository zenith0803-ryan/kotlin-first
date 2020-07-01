package com.kotlin.six

import CollectionUtils

fun printlnUpperCase(list:List<String>){  //읽기전용 파라미터
    println(CollectionUtils.uppercaseAll(list))  //컬렉션을 변경하는 자바함수호출
    println(list.first())
}
fun main(args: Array<String>){
    val list = listOf("a","b","c")
    printlnUpperCase(list )
}