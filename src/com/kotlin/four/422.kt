package com.kotlin.four

import javax.naming.Context
import javax.print.attribute.AttributeSet

// 4.2.2 부 생성자 : 상위클래스를 다른 방식으로 초기화
// 일반적으로 코틀린에서는 생성자가 여럿있는 경우가 자바보다 훨씬 적다.
// 코틀린의 디폴트 파라미터값과 이름붙은 인자 문법을 사용해 해결할수 있다.

open class View1{
    constructor(ctx: Context){}  //부생성자들
    constructor(ctx : Context, attr: AttributeSet){} //부생성자들
}

class MyButton : View1{
    constructor(ctx: Context):super(ctx){
    }
    constructor(ctx : Context, attr: AttributeSet): super(ctx, attr){

    }
    //상위 클래스의 생성자를 호출한다.
    // super()키워드를 통해 자신에 대응하는 상위클래스 생성자를 호춯한다.
}

class MyButton2 : View1{

    //constructor(ctx: Context): this(ctx, MY_STYLE)
    constructor(ctx: Context, attr: AttributeSet): super(ctx, attr){

    }
}
//부생성자가 필요한 주된 이유는 "자바 상호운용성"
// 또다른 이유는 -> 클래스 인스턴스를 생성할때 파라미터 목록이 다른 생성방법이 여럿 존재하는 경우 4.4.2