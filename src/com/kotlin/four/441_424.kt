package com.kotlin.four

import java.util.*

// 4.24 중첩객체를 사용해 Comparator구현하기

data class Person(val name: String){
    object NameComparator : Comparator<Person> {
        override fun compare(p1 : Person , p2 : Person ) : Int =
            p1.name.compareTo(p2.name)
    }
}

fun main (args : Array<String>){
    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons)
    println(persons.sortedWith( Person.NameComparator))
}
