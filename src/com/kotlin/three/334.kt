package com.kotlin.three

//3.3.4 확장함수는 오버라이드할수 없다.

//멤버함수 오버라이드하기
open class View{
    open fun click() = println("View clicked")
}
class Button: View(){// Button은 View를 확장한다.
    override fun click() = println("Button clicked")

}

fun main(args: Array<String>){
    val view: View = Button()
    view.click()  // view에 저장된 값의 실제타입에 따라 호출할 메소드가 결정된다.

    view.showOff() //확장함수는 정적으로 결정된다. 오버라이드할수 없다.
    //view가 가리키는 객체타입은 Button , 이경우 view의 타입이 View이기때문에 View의 확장함수가 호출된다.
    // 왜냐면 확장함수는 첫번째 인자가 수신객체인 정적 자바메소드로 컴파일 하기때문이다.
}

//확장함수는 클래스의 일부가 아니고 클래스 밖에 선언된다.
// 확장함수 호출시 수신객체로 지정한 변수의  정적타입에 의해 어떤 함수가 호출될지 결정된다.
// 그 변수에 저장된 객체의 동적인 타입에 의해 확장함수가 결정되지 않는다.

// 3.6 확장함수는 오버라이드할수 없다.
fun View.showOff() = println("I am a view!")
fun Button.showOff() = println("I am a button")
