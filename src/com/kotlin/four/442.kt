package com.kotlin.four

//4.4.2 동반객체 : 팩토리 메소드와 정적멤버가 들어갈 장소
// 코틀린 클래스안에는 static member가 없고 static키워드를 지원하지 않는다.
// But  패키지수준의 최상위 함수 -> java static method 대신
//      객체선언 -> java static method역할중 코틀린 최상위 함수가 대신살수 없는 역할이나 static filed를 대신함
//  최상위 함수활용을 권장
// 그림 4.5처럼 private으로 표시된 클래스 비공개 멤버에 접근할 수 없다.
//  클래스에 중첩된 객체 선언의 멤버함수로 정의해야한다 ->  factory method

class A {
    companion object {  // companion : 그 클래스의 동반객체

        fun bar() {
            println("Companion object called")
        }
    }
}
fun main (args : Array<String>){
    // 자바의 정적 메소드 호출이나 정적 필드 사용구문과 같다
    println(A.bar())
}
// 동반 객체가 private 생성자를 호출하기가 좋다.
// 동반객체는 Factory Pattern을 구현하기 적합한 위치다.
