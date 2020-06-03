package com.kotlin.four

// list 4.21 Client를 데이터 클래스로 선언하기

data class Client1(val name:String, val postalCode: Int)
// 위 클래스는 자바에서 요구하는 모든 메소드를 포함한다.
// 인스턴스간 비교를 위한 equals
// HashMap과 같은 해시기반 컨테이너에서 키로 사용할수 있는 hashCode
// 클래스의 각 필드를 선언순서대로 표시하는 문자열 표현을 만들어주는 toString

// 데이터클래스와 불변성 : copy()메소드
// 데이터클래스를 immutable 클래스로 만들라고 권장한다.


fun main(args : Array<String>){
    //copy method 사용해보기
    val lee = Client1("이계영", 500)
    val lee2 = lee.copy(postalCode = 600)
    println(lee)
    println(lee2)
}