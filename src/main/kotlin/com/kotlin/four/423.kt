package com.kotlin.four

//4.2.3 인터페이스에 선언된 프로퍼티 구현

// 추상프로퍼티 선언이 들어있는 인터페이스 선언예시
interface User1{
    val nickname: String
}

//별명을 저장
class PrivateUser(override val nickname: String): User1 // 주생성자에 있는 프로퍼티
// User1의 추상프로퍼티를 구현하고있으므로 override를 표시해야한다.

//이메일을 함께 저장
class SubscribingUser(val email : String ) : User1{
    override val nickname : String
        get() = email.substringBefore('@')  //커스텀 게터
}
// FaceBook 계정의 아이디를 저장
class FacebookUser(val accountId : Int ) : User1{
    //초기화식으로 nickname값을 초기화한다. 이때 사용자ID를 받아서 그 사용자의 이름을 반환
    override val nickname : String = getFacebookName(accountId)  //프로퍼티 초기화식
    fun getFacebookName(  accountId : Int) : String {
        //println("accountId : "+ accountId)
        return "Ryan"
    }
}

fun main (args : Array<String>){
    println(PrivateUser("test@kotlinglang.org").nickname)
    println(SubscribingUser("test@kotlinglang.org").nickname)
    println(FacebookUser(300).nickname)
}
