package com.kotlin.four

import java.lang.Exception
import java.lang.IllegalArgumentException

// 4.1.5 봉인된 클래스 : 클래스 계층 정의시 계층 확장제한

//4.12
interface Expr
class Num(val value: Int) : Expr
class Sum(val left:Expr, val right : Expr) : Expr
    fun eval(e: Expr): Int =
    when(e){
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression")  // else분기가 꼭있어야한다
    }

// kotlin complier는 when을 사용해 Expr타입 값을 검사할때 꼭 디폴트 분기인 else분기를 강제한다.
// -> 컴파일러가 when이 모든경우를 처리하는지 알수 없다. 그래서..sealed
// 상위클래스에 sealed를 붙이면 그 상위클래스를 상속한 하위클래스 정의를 제한할수 있다.
// sealed 클래스의 하위클래스를 정의할때 반드시 상위클래스안에 중첩시켜야한다.


// 4.13
sealed class Expr2{  //기반클래스를  sealed로 봉인
    class Num(val value : Int): Expr2()  //기반클래스의 모든 하위클래스를 중첩클래스로 나열한다.
    class Sum(val left:Expr2, val right: Expr2 ): Expr2()
}

fun eval(e: Expr2): Int =
    when(e) {  //when식이 모든 하위클래스를 검사하므로 별도의 else 가 불필요하다.
        is Expr2.Num -> e.value
        is Expr2.Sum -> eval(e.right) + eval(e.left)
    }

// sealed 클래스는 자동 open
// Kotlin1.0 : sealed 제약이 심하다 - 모든하위클래스는 중첩클래스여야한다. 데이터 클래스로 sealed class를 상속할수없다.
// Kotlin1.1 : 제한이 완화. 봉인된 클래스와 같은 파일의 아무데서나 봉인된 클래스를 상속한 하위클래스를 만들수 있고, 데이터 클래스로 하위클래스를 정의할수있다.

