package com.kotlin.four

// 4.1.3 가시성변경자 : 기본적으로 공개
//가시성변경자 visibility modifier 는 코드기반에 있는 선언에 대한 클래스 외부접근을 제어한다.
// 자바와 비슷하다. 아무변경자가 없으면 public
// 자바의 기본가시성은 package-private 이건 코틀린에 없다. 코틀린은 패키지를 네임스페이스를 관리하기 위한용도
// internal 도임 : 모듈내부에서만 볼수있음 - 진정한 캡슐화를 제공
// Java : package가 같은 클래스선언하면 외부에 있는 코드도 패키지전용선언에 접근가능 - 모듈화가깨진다
// Kotlin : 최상위 선언에 대히 private 가시성을 허용.

//4.2 코틀린의 가시성 변경자(책참조)


internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

fun TalkativeButton.giveSpeech(){  // public멤버가 자신의internal 수신타입인 TalkativeButton을 노출함
    yell()      //오류 yell에 접근할수 없음, yell은 TalkativeButton의 private
    whisper()  // 오류 : whisper는 TalkativeButton의 protected멤버
}

// public 함수이 giveSpeech에서 그보다 가시성이 낮은 (internal) 타입인 TalktaveButtond 을 참조할수 없다.
// 클래스자신의 가시성과 같거나 높아야하고 메소드 시그니처에 사용된 모든타입의 가시성은 그 메소드의 가시성과 같거나 높어야 한다.
// 자바에선 같은 패키지안에서 protected멤버에 접근했지만 코틀린은 그렇지않다.
// 코틀린은 protected 멤버는 오직 어떤 클래스나 그 클래스를 상송한 클래스에서만 보인다.