package com.kotlin.four

import com.kotlin.two.two.Person

// 4.4 object 키워드 : 클래스 선언과 인스턴스 생성
// 코틀린에서 object는 클래스를 정의 하면서 동시에 인스턴스(객체)를 생성한다.
// - object declation :  싱글턴을 정의하는 방법중 하나
// - companion object 동반객체 : 인스턴스 메소드는 아니지만 어떤 클래스와 관련있는 메소드와 팩토리 메소드를 담을때 쓰인다.
// - 객체식은 자바의 무명내부클래스(anonymous inner class) 대신 쓰인다.

// 4.4.1 객체선언 : 싱글턴을 쉽게 만들기
// Java : 보틍 클래스의 생성자를 private로 제한, static 필드에 그 클래스의 유일한 객체를 저장하는 Singleton Patter을 통해 구현
// Kotlin : 객체선언기능을 통해 싱글턴을 언어에서 기본지원
//           객체선언 = 클래스 선언 + 그 클래스에 속한 단일 인스턴스의 선언

object Payroll{  // 객체선언은 object 키워드로 시작
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary(){
        for( person in allEmployees){

        }
    }
}
// 클래스와 비슷하지만 생성자는 객체선언에 쓸수 없다!
// 왜냐면 싱글턴 객체는 객체선언문이 있는 위치에서 생성자 호출없이 즉시 만들어져서 생성자 정의가 필요없다.
fun main(args : Array<String>){
    // 객체선언에 사용한 이름뒤에 마침표(.)를 붙이면 객체에속한 메소드나 프로퍼티에 접근할수 있다.
    Payroll.allEmployees.add(Person( "Ryan"))
    Payroll.allEmployees.add(Person( "Elon"))
    Payroll.calculateSalary()
}
