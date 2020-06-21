package com.kotlin.four

//list 4.29 동반객체에 대한 확장함수 정의하기

// 비지니스 로직 모듈
class Person32(val firstName: String , val lastName: String){
    companion object  {  // 비어있는 동반객체를 선언
    }
}

// 클라이언트 서버 통신모듈
fun Person32.Companion.fromJSON(json: String) : Person32{
    return Person32("JaeHo", "Shin")
}

val p = Person32.fromJSON("JsonData")
 
