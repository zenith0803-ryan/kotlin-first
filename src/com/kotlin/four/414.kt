package com.kotlin.four

import java.io.Serializable

// 4.1.4  내부클래스와 중첩된 클래스 : 기본적으로 중첩클래스

//코틀린의 중첩클래스는 명시적으로 요청하지 않는 한 바깥쪽 클래스 인스턴스에 대한 접근권한이 없다.

// 4.9 직렬화할수 있는 상태가 있는 뷰
interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}

//리스트 4.10 책을보자


class Button3 : View{
    override fun getCurrentState() : State = ButtonState()

    override fun restoreState(state : State) {
        TODO("Not yet implemented")
    }

    class ButtonState : State {}  // 자바의 정적 중첩클래스와 대응

}

// 표 4.3을 보자
