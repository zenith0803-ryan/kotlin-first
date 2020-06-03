package com.kotlin.four

// 4.1.2 open, final,abstract 변경자 : 기본적으로 final

//기본적으로 상속이가능하면 편리하지만 문제가 생기는 경우가 많다.
// Fragile base class (취약한 기반 클래스) : 하위클래스가 기반클래스에 대해 가졌던 가정이 기반 클래스를 변경함으로써 깨져버린경우
// 기반 클래스를 변경하는 경우 하위 클래스의 동작이 예기치 않게 바뀔수도 있다는 면에서 기반 클래스는 '취약'하다.
// "Effective Java" 상속을 위한 설계와 문서를 갖추거나, 그럴수 없다면 상속을 금지하라
// 하위클래스에서 오버라이드하게 의도된 클래스와 메소드가 아니라면 모두 final로 만들라
// Kotlin : 코틀린의 클래스와 메소드는 기본적으로 final!! 상속을 허용하려면 클래스앞에 open변경자를 붙여야한다.

//4.6
open class RichButton: Clickable{ // 이 클래스는 열려있다. 다른클래스가 이클래스를 상속할수 있다.
    fun disable(){}  //이 함수는 파이날이다. 하위클래스가 오버라이드할수 없다.
    open fun animate(){}  // 이함수는 열려있다. 하위클래스에서 이 메소드를 오버라이드해도 된다.
    //override fun click() {  // 이함수는 상위클래스에서 선언된 열려있는 메소드를 오버라이드한다. 상속가능
      //  TODO("Not yet implemented")
    //}
    //4.7
    final override fun click(){ // 상속못한다.

    }
}

//final로 얻는 이익중 하나는 다양한 경우에 스마트 캐스트가 가능한것. 스마트캐스트는 타입검사뒤에 변경될수 없는 변수에만 적용 가능하다.
// val && 커스텀접근자가 없는경우만 스마트캐스트사용가능 -> property가 final이어야 한다는 뜻


// 4.8 추상 클래스 정의하기
abstract class Animated{  // 이 함수는 추상클래스다. 이 클래스의 인스턴스를 만들수 없다.
    abstract fun animate()  //추상함수. 하위클래스에서 반드시 오버라이드해야한다.
    open fun stopAnimating(){}  // 추상클래스에 있는 비추상함수는 기본적으로 final  but open으로 오버라이드 허용 가능
    fun animateTwice(){}  //
}
// 인터페이스 멤버는 항상 열려있으며 final로 변경불가
// 표 4.1 클래스 내애ㅔ서 상속제어 변경자의  의미
// final    override 불가     클래스멤버의 기본변경자
// open     override 가능     반드시open을 명시해야 오버라이드할수 있다.
// abstract 반드시 override해야  추상클래스의 멤버에만 이 변경자를 붙일수 있다.
// override 상위클래스나 상위인스턴스의 멤버를 오버라이드    오버라이드하는 멤버는 기본적으로 열려있고 하위클래스 오버라이드를 금지하려면 final명시해야한다.

