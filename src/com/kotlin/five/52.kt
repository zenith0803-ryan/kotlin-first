package com.kotlin.five


fun main(args: Array<String>){
    val list = listOf(1,2,3,4)
    println( list.filter { it % 2 == 0 })
    println(list.map { it * it })

    val people = listOf(Person("Alice", 29), Person("Bob", 31), Person("Ryan", 42))
    println(people.map {it.name})
    println(people.map(Person::name))
    println(people.filter{ it.age>=30}.map(Person::name))

    //people.filter{it.age == people.maxBy(Person::age)}

    //tip double bang
    //http://kotlinprogrammer.blogspot.com/2017/07/kotlin-double-exclamation-operator.html
    println(  people.maxBy(Person::age)!!.age )
    println( people.filter { it.age == people.maxBy(Person::age)!!.age } )

    val maxAge = people.maxBy(Person::age)!!.age
    println ( people.filter { it.age == maxAge } )

    val numbers = mapOf( 0 to "zero" , 1 to "one")
    println( numbers.mapValues { it.value.toUpperCase() })
}