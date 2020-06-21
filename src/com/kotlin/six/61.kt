package com.kotlin.six

fun strLen(s: String) = s.length

fun strLenSafe(s: String?) = s?.length

fun strLenSafe2(s: String?): Int =
    if(s!=null) s.length else 0



fun main(args: Array<String>){
    //println(strLen("Ryan"))
    //println(strLen( null))

//    println(strLenSafe(null))
    val x : String? = null
    println(strLenSafe2(x))
    println(strLenSafe2("ABC"))
}