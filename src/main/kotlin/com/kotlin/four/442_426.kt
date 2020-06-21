package com.kotlin.four

/// 리스트 4.26 :  부 생성자를 팩토리 메소드로 대신하기
class User02  private constructor(val nickname: String){ //주생성자를 비공개로 만든다.
    companion object{ // 동반객체를 선언
        fun newSubscribingUser(email: String ) =
            User02(email.substringBefore('@'))

        fun newFacebookUser(accountId : Int ) = //페이스북 사용자아이디로 사용자를 만드는 팩토리 메소드
            User02(getFacebookName(accountId))

        fun getFacebookName(  accountId : Int) : String {
            //println("accountId : "+ accountId)
            return "Ryan"
        }
    }
}

fun main (args: Array<String>){
    val subscribingUser = User02.newSubscribingUser("bob@gmail.com")
    val facebookUser = User02.newFacebookUser(5)
    println(subscribingUser.nickname)
    println(facebookUser.nickname)
}

// 팩토리 메소드
// 목적에 따라 팩토리 메소드 이름을 정할수 있다.!!
// 팩토리 메소드는 그 팩토리 메소드가 선언된 클래스의 하위클래스객체를 반환할수 있다.
// 생성할 필요가 없는 객체를 생성하지 않을수도 있다.
//  ㄴ 이미 존재하는 인스턴스에 해당하는 이메일 주소를 받으면  캐시에 있는 기존 인스턴스를 반환할수 있다.

