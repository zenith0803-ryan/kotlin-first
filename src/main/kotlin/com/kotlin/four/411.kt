package com.kotlin.four

//4.1클래스 계층정의
// 4.1.1 코틀린 인터페이스

interface Clickable{
    fun click()
    fun showOff() = println("I'm clickable" ) //디폴트구현이 있는 메소드
}

class Button : Clickable{
    override fun click() = println("I was clicked")

}
//자바 : extends, implement 키워드사용
//코틀린 : 클래스이름뒤에 콜론(:)을 붙이고 인터페이스와 클래스이름을 적는것으로 클래스확장과 인터페이스 구현을 모두 처리한다.
// override 변경자 : 상위클래스나 상위인터페에스에 잇는 프로퍼티나 메소드를 오버라이드한다는 표시다.

// 4.4 동일한 메소드 구현를 구현하는 다른 인터페이스정의
interface Focusable{
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable")

}
//한클래스에서 두개의 인터페이스를 구현하면??? -> 어느쪽 메소드도 선택되지 않는다.
//클래스가 구현하는 두 상위 인터페이스에 정의된 shoOff구현을 대체할 오버라이딩 메소드를 직접 제공하지 않으면 오류가 발생한다.
class Button2 : Clickable, Focusable{
    override fun click() = println("I was clicked")

    override fun showOff() {  // 이름과 시그니쳐가 같은 멤버 메소드에 대해 둘 이상의 디폴트 구현이 있는 경우 인터페이스를 구현하는
        // 하위 클래스에서 명시적으로 새로운 구현을 제공해야한다.
        super<Clickable>.showOff()
        super<Focusable>.showOff()
        // 상위타입의 이름을 꺽쇠 괄호사이에 넣어서 "super"를 지정하면 어떤 상위 타입의 멤버 메소드를 호출할지 지정할수 있다.
        // java : Clickable.super.showOff()
    }

}

fun main ( args: Array<String>){
    Button().click()

    Button2().showOff()
    println("==========")
    val button = Button2()
    button.showOff()
    button.setFocus(true)
    button.click()
}

//