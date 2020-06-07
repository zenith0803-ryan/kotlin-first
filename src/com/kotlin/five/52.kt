package com.kotlin.five



fun main(args: Array<String>){
    val list = listOf(1,2,3,4)
    println( list.filter { it % 2 == 0 })
    println(list.map { it * it })

    val people = listOf(Person("Alice", 27), Person("Bob", 31), Person("Ryan", 42), Person("Carol", 31))
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

    val canBeInClub27 = {p : Person  -> p.age<=27 }
    println( people.all(canBeInClub27))
    println( people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.filter(canBeInClub27).size) //지양하자 -> 중간 컬렉션이 생겨서 비효율적
    println(people.find(canBeInClub27))

    println(people.groupBy { it.age })

    val list2 = listOf("a", "ab", "b")
    println(list2.groupBy(String::first))

    class Book(val title: String, val authors: List<String>)
    val books = listOf(Book("토지", listOf("김진명","김경리")) , Book("토끼인형", listOf("크레","김경리"))  )
    println (books.flatMap { it.authors }.toSet()) //books 컬렉션에 있는 책을 쓴 모든 저자의 집합

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })
}