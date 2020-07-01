package com.kotlin.six

import JavaPerson
import java.awt.event.ActionEvent
import javax.swing.AbstractAction
import javax.swing.JList
import StringProcessor


fun strLen(s: String) = s.length

fun strLenSafe(s: String?) = s?.length

fun strLenSafe2(s: String?): Int =
    if(s!=null) s.length else 0



fun main(args: Array<String>){
    println("list 6.1")
    println(strLen("Ryan"))
    //println(strLen( null))

    println(strLenSafe(null))
    val x : String? = null
     println(strLenSafe2(x))
    println(strLenSafe2("ABC"))
    println("list 6.2")
   class Employee(val name: String, val manager:Employee?)
    fun managerName(employee : Employee): String? = employee.manager?.name
    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
   // println(managerName(developer))
    //println(managerName(ceo))
    println("list 6.3 안전한 호출 연쇄시키기")
    class Address ( val streetAddress: String, val zipCode : Int, val city: String, val country : String)
    class Company ( val name: String, val address: Address?)
    class Person(val name: String, val company : Company?)
    fun Person.countryName(): String{
        val country = this.company?.address?.country  //여러 안전한 호출 연산자를 연쇄해 사용한다.
        return if(country != null) country else "Unknown"
    }
    val person = Person("Dmitry", null)
    println(person.countryName())

    println("list 6.4 엘비스 연산자를 활용해 널값 다루기")
    fun strLenSafe(s: String?) : Int = s?.length ?: 0
    println(strLenSafe("abc"))
    println(strLenSafe(null))

    println("list 6.5 thorw 와 엘비스 연산자 함께 사용하기")
    fun printShippingLabel(person : Person){
        val address = person.company?.address ?: throw IllegalArgumentException("No address") //주소가 없으면 예외를 발생시킨다.
        address.apply {      // "address" 는 널이 아니다.
            println(streetAddress)
            println("$zipCode $city , $country")
        }
    }

    val address = Address ("삼평로", 13689, "성남시", "한국")
    val kakao = Company("카카오", address)
    val person_ = Person("Ryan", kakao)
    printShippingLabel( person_)
    //printShippingLabel(Person("Nugu", null ))

    println("list 6.6 안전한 연산자를 사용해 equals 구현하기")
    class Person2(val firstName: String, val lastName: String){
        override fun equals(other : Any?) : Boolean {
            val otherPerson = other as? Person2 ?: return false // 타입이 일치하지 않으면 false를 반환한다.
            return otherPerson.firstName == firstName &&  // 안전한 캐스트를 하고 나면 otherPerson이 Person2타입으로 스마트캐스트된다.
                    otherPerson.lastName == lastName
        }

        override fun hashCode() : Int = firstName.hashCode() * 37 + lastName.hashCode()
    }
    val p1 = Person2("Ryan","Shin")
    val p2 = Person2("Ryan","Shin")
    println(p1==p2)
    println(p1.equals(p2))
    println(p1.equals(42))
    val p3 = Person("You",null)
    println(p1.equals(p3))

    println("list 6.7 널아님 단언 사용하기 ")
    fun ignoreNulls(s: String?){
        val sNotNull: String = s!!
        println(sNotNull.length)
    }
    ignoreNulls("str")
    //ignoreNulls(null)

    println("list 6.8 스윙액션에서 널 아님 단언 사용하기")
    class CopyRowAction(val list:JList<String>): AbstractAction(){
        override fun isEnabled() : Boolean  = list.selectedValue != null

        override fun actionPerformed(e : ActionEvent?) {  // actionPerformed는 isEnabled가 true인 경우에만 호출된다.
            val value = list.selectedValue!!
            println("value를 클립보드로 복사")
        }
    }

    println("list 6.9 let을 사용해 null이 아닌 인자로 함수 호출하기  ")
    fun sendEmailTo(email: String){
        println("Sending email to $email")
    }
    var email : String? = "ryan.shin@kakaocorp.com"
    email?.let{ sendEmailTo(it)}

    email = null
    email?.let { sendEmailTo(it) }


    //test

    println("list 6.12 null이  될수 있는 수신객체에 대해 확장함수 호출하기")
    fun verifyUserInput(input: String?){
        if(input.isNullOrBlank()){   //안전한 호출을 하지 않아도 된다.
            println("Please fill in the required fields")
        }
    }
    verifyUserInput(null)
    verifyUserInput(" ")

    println("list 6.13 널이 될수 있는 타입 파라미터 다루기")
    fun<T> printHashCode(t: T){
        println(t?.hashCode())  //t가 널이 될수 있으므로 안전한 호출을 해야한다.
    }
    printHashCode(null)  //T 타입은 Any?로 추정된다.

    println("list 6.14 타입파라미터에 대해 널이 될수 없는 상한을 사용하기")
    fun<T: Any> printHashCode2(t:T){  //T:Any -> T는 널이 될수 없다.
        println(t.hashCode())
    }
    //printHashCode2(null)
    printHashCode2(234)

    println("list 6.16 null검사없이 자바클래스 접근하기")
    fun yellAt(javaPerson: JavaPerson){
        println(javaPerson.name.toUpperCase() + "!!!") // toUpperCase()의 수신객체 person.name이 널이어서 예외가 발생함
    }
    //yellAt( JavaPerson(null))
    //java.lang.IllegalArgumentExceptoin : Parameter specified as non-null
    //is null : method toUpperCase, paramemter $receive
    fun yellAt2(javaPerson: JavaPerson){

        println(javaPerson.name ?: "AnyOne".toUpperCase() + "!!!") // toUpperCase()의 수신객체 person.name이 널이어서 예외가 발생함
    }
    yellAt2(JavaPerson(null))

    println("list 6.19 자바인터페이스를 여러 다른 널 가능성으로 구현하기")
    class StringPrinter : StringProcessor{
        override fun process(value: String) {
            println(value)
        }
    }
    class NullableStringPrinter : StringProcessor{
        override fun process(value: String?) {
            if( value != null){
                println(value)
            }
        }
    }
}