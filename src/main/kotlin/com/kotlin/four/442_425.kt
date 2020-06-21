package com.kotlin.four


// 리스트 4.25 :  부 생성자가 여럿있는 클래스 정의하기
class User01 {
    val nickname : String

    // 부생성자
    constructor(email: String ){
        nickname = email.substringBefore('@')
    }
    // 부생성자
    constructor(faceBookAccountId: Int){
        nickname = getFacebookName(faceBookAccountId)
    }
    fun getFacebookName(  accountId : Int) : String {
        //println("accountId : "+ accountId)
        return "Ryan"
    }

}
