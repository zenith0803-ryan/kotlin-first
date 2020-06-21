package com.kotlin.four

import java.awt.SystemColor.window
import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JFrame

// 4.4.4 객체 식 : 무명 내부 클래스를 다른방식으로 작성
// 무명객체 anonymous object를 정의할때도 object키워드를 사용한다.
// 무명객체는 자바의 무명내부 클래스를 대신하다.

// list 4.30  무명객체로 이벤트 리스너 구현하기
fun main(args : Array<String>){
    val window = JFrame()
    window.addMouseListener(
        object : MouseAdapter(){  // MouseAdapter를 확장하는 무명객체를 선언한다.
            // 아래 두 메소드는  MouseAdapter의 메소드를 오버라이드한다.
            override fun mouseClicked(e: MouseEvent) {
            }

            override fun mouseEntered(e: MouseEvent) {
            }
        }
    )

    // 객체에 이름을 붙여야 한다면 변수에 무명객체를 대입하면된다.
    val listener = object : MouseAdapter(){
        override fun mouseClicked(e: MouseEvent) {}
        override fun mouseEntered(e: MouseEvent) {}
    }

    //코틀린의 무명클래스는 여러 인터페이스를 구현하거나 클래스를 확장하면서 인터페이스를 구현할수 있다.
    // 무명객체는 싱글턴이 아니다. 객체식이 쓰일때마다 새로운 인스턴스가 생성된다.
}

// list 4.31 무명객체안에서 로컬변수사용하기
// 객체식 안의 코드는 그 식이 표함된 함수의 변수에 접근할수 있다.
// 자바와 다르게 final이 아닌 변수도 사용할수 있다
fun countClicks(window : Window){
    var clickCount = 0  // 로컬변수 정의
    window.addMouseListener(object  :MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            clickCount++  //로컬변수값 변경
        }
    })
}
///

