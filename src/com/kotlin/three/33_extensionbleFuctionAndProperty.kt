package com.kotlin.three

import strings.lastChar


// 3.3 메소드를 다른클래스에 추가 : 확장함수와 확장프로퍼티
// 기존코드와 코틀린코드를 자연스럽게 통합하는것이 코틀린의 핵심목표중 하나
// 확장함수 : 기존자바API를 재작성하지않고도 코틀린이 제공하는 여러 편리한 기능을 사용할수 있다.
// 확장함수는 클래스의 밖에 선언된 함수
// See the strings package...

// 호출
fun main(args: Array<String>){
    println("kotlin".lastChar()) //Stirng이 수신객체타입, "kotlin"이 수신객체
    // String class에 새로운 메소드를 추가하는것과 같다.
}


