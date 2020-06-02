package com.kotlin.two.two

import java.util.*

//패키지선언

class Rectangle (val height : Int, val width : Int){
    // isSquare는 자체값을 저장하는 프로퍼티가 없고 게터만 존재한다.
    val isSquare:Boolean
        get() {   //property getter 선언
            return height == width
        }
    val isSquare2:Boolean = height == width
}

// 2.2.3 소스코드구조 디렉토리와 패키지
// 코틀린 package : 그 파일안에 있는 모든 선언이 해당 패키지에 들어간다. 같은 패키지에 있으면 다른 파일에서 정의한 선언일지라도 직접사용 가능하다.
//                반면 다른 패키지에서 정의한 선언을 사용하려면 임포트를 한다.

fun createRandomRectangle(): Rectangle{
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

// 자바는 디렉토리구조가 패키지구조를 그대로 따라야한다..
// 코틀린은 패키지구조와 디렉토리구조가 맞아 떨어질필요가 없다.. 하지만 자바와 같이 디렉토리를 구성하는 편이 좋다.