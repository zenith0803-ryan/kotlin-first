package com.kotlin.six

import com.kotlin.three.list

fun main(args: Array<String>){
    fun showProgress(progress : Int){
        val percent = progress.coerceIn(0,100)
        println("we're ${percent}% done")
    }
    showProgress(987)
    showProgress(-10)
    showProgress(33)

    println("리스트 6.20 널이 될수 있는 원시타입")
    data class Person(val name: String, val age: Int? = null){
        fun isOlderThan(other: Person): Boolean?{
            if( age == null || other.age == null)
                return null

            return age>other.age
        }
    }
    println(Person("Sam", 35).isOlderThan(Person("Amy" , 42)))
    println(Person("Sam", 35).isOlderThan(Person("Jane" )))

    val x = 1
    val list = listOf(1L, 2L, 3L)
    //x in list
    x.toLong() in list

    fun foo(l:Long) = println(l)
    val b:Byte = 1
    val l = b + 1L   //+는 바이트와 Long인자로 받을수 있다.
    foo(42)  //컴파일러는 42를 Long값으로 해석한다.

    fun fail (message: String) : Nothing{
        throw IllegalStateException(message)
    }
    fail("Error occured")
}