package com.kotlin.six

import org.junit.Before
import org.junit.Test
import org.junit.Assert

class MyService{
    fun performAction(): String = "foo"
}
class MyTest{

    private var myService: MyService? = null //null로 초기화하기 위해 널이 될수 있는 타입인 프로퍼티를 선언한다.

    @Before
    fun setUp(){
        myService = MyService() //setUp메소드안에서 진짜 초기값을 지정한다.
    }

    fun testAction(){
        Asser
    }

}