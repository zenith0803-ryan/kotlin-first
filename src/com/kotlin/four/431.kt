package com.kotlin.four

// 4.3.1 모든 클래스가 정의해야하는 메소드

// list 4.17 Client Class 초기정의
class Client(val name: String, val postalCode: Int)

// 문자열표현 toString()

//list 4.18 Client에 toString()구현
class Client2(val name:String, val postalCode : Int){
    override fun toString()  = "Client(name=$name, postalCode=$postalCode)"
}

class Client3(val name:String, val postalCode : Int){
    override fun equals(other : Any?) : Boolean {  //Any - java.lang.Object에 대응하는 클래스로 코틀린의 모든클래스의 최상위클래스
                                                        // Any? 는 널이될수 있는 타입
        if( other == null || other !is Client3)
            return false
        return name == other.name && postalCode == other.postalCode
    }
    override fun toString()  = "Client(name=$name, postalCode=$postalCode)"
}

// list 4.20 Client에 hashCode구현하기
class Client4(val name:String, val postalCode : Int) {
    override fun equals(other : Any?) : Boolean {  //Any - java.lang.Object에 대응하는 클래스로 코틀린의 모든클래스의 최상위클래스
        // Any? 는 널이될수 있는 타입
        if( other == null || other !is Client3)
            return false
        return name == other.name && postalCode == other.postalCode
    }
    override fun toString()  = "Client(name=$name, postalCode=$postalCode)"
    override fun hashCode() : Int = name.hashCode() * 31 + postalCode
}


fun main(args: Array<String>){
    println("4.18 test code")
    val client1 = Client2("롸이언", 4122)
    println(client1)
    val client2 = Client2("롸이언", 4122)
    println(client1 == client2)  // ==연산자는 객체의 동등성을 검사한다.
    // == 연산은  equals를 호출하는식으로 컴파일된다.


    println("4.19 test code")
    val client3 = Client3("롸이언", 4122)
    val client4 = Client3("롸이언", 4122)
    println(client3 == client4)


    //hashCode
    println("hashCode")
    val processed = hashSetOf(Client3("롸이언",4122))
    println(processed)
    println(Client3( "롸이언",4122))
    println(processed.contains (Client3( "롸이언",4122)))
    // hashcode 구현한 Client4
    val processed2 = hashSetOf(Client4("그대여",4122))
    println(processed2.hashCode())
    println(Client4( "그대여",4122).hashCode())
    println(  processed2.contains( Client4( "그대여",4122) ))


}