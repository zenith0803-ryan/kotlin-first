package com.kotlin.five

import java.awt.Button
import java.net.CacheResponse
import javax.swing.JButton


data class Person(val name: String, val age : Int)
fun findTheOldest(people: List<Person>){
    var maxAge = 0
    var theOldest : Person? = null
    for(person in people){
        if ( person.age > maxAge){
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}
//5.10 함수파라미터를 람다안에서 사용하기
fun printMessageWithPrefix(messages : Collection<String>, prefix :String ){
    messages.forEach {
        println("$prefix $it")
    }
}

// 5.11 람다안에서 바깥함수의 로컬변수 변경하기
fun printProblemCounts(response : Collection<String>){
    var clientErrors = 0  //람다에서 사용할 변수를 정의한다.
    var serverErrors = 0
    response.forEach{
        if( it.startsWith("4"))
            clientErrors++  //람다에안에서 람다 밖의 변수를 변경한다.
        else if(it.startsWith("5"))
            serverErrors++
    }
    println("$clientErrors client errors, $serverErrors servdr errors")
}
fun tryToCountButtonClicks(button: Button): Int{
    var clicks = 0
    //button.onClick(clicks++)
    return clicks
}
fun salute() = println("Salute!")
val action = {person:Person, message : String ->  //이 람다는 sendEmail함수에게 작업을 위임한다.
    sendEmail(person, message)
}
val nextAction = ::sendEmail  //람다대신 멤버참조를 쓸수 있다.
fun sendEmail(person:Person, message : String){
    println("SendEmail TO ${person.name } message : $message")
}
fun Person.isAdult() = age >=21
val predicate = Person::isAdult

fun main(args : Array<String>){
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    findTheOldest(people)

    println(people.maxBy { it.age })

    println(people.maxBy (  Person::age  ) )

    //5.6
    val names = people.joinToString (   separator = " ", transform = { p:Person -> p.name})
    println(names)

    //5.7
    people.joinToString (" "){ p:Person -> p.name }

    //5.8 람다파라미터 타입 제거하기
    people.maxBy { p:Person -> p.age }  //파라미터 타입을 명시
    people.maxBy { p -> p.age } //파라미터타입을 생략(컴파일러가 추론)

    //5.9 디폴트 파라미터 이름 it 사용하기
    people.maxBy { it.age }

    val getAge = {p: Person -> p.age}
    people.maxBy(getAge)

    val sum = {x: Int, y: Int ->
        println("Computing the sum of $x and $y...")
        x+y
    }
    println(sum(1,2))

    //5.10
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(errors, "Error:")

    //5.11
    println("5.11 람다안에서 바깥함수의 로컬변수 변경하기")
    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)
    println("-------------")
    run ( ::salute )

    println("-------------")
    val createPerson = ::Person
    val p = createPerson("Alice", 29)
    println(p)


}
