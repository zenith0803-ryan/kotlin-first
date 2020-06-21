package com.kotlin.six

import org.junit.Before

class MyService{
    fun performAction() : String = "foo"
}
class MyTest{
    private var myService : MyService? = null // null로 초기화 하기위해 널이 될수 있는 타입인 프로퍼티를 선언한다.
    @Before
    fun setUp(){
        myService = MyService()  //setup메소드안에서 진짜 초깃값을 지정한다.
    }

}