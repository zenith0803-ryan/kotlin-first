package com.kotlin.two.two

import java.lang.IllegalArgumentException

// 스카트캐스트 : 타입검사와 타입캐스트를 포함
interface Expr

//value라는 프로퍼티만 존재하는 단순한 클래스 Expr인터페이스를 구현
class Num (val value : Int) : Expr

//Expr타입의 객체라면 어떤것이나 Sum의 인자가 될수 있다. 따라서 Num이나 다른 Sum이 인자로 온다.
class Sum( val left : Expr, val right : Expr) : Expr


fun eval ( e: Expr) : Int {
    if( e is Num){
        val n = e as Num //Num으로 타입변환 불필요한 중복
        return  n.value
    }
    if( e is Sum){
        return  eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}
// 어떤 변수가 원하는 타입인지 is감사하고나면 캐스팅안해도 그 변수가 원하는 타입으로 선언된것처럼 사용 -> 스마트캐스트

//명시적 타입캐스팅 as
//val e = 5
//val n = e as Num

//return과 중괄호를 없앤다.
fun eval2 ( e: Expr) : Int  =
    if( e is Num){
        e.value
    }else if( e is Sum){
        eval2(e.right) + eval2(e.left)
    }else {
        throw IllegalArgumentException("Unknown expression")
    }

fun eval3( e: Expr) : Int =
    when ( e ){
        is Num -> e.value
        is Sum -> eval3(e.right) + eval3(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }

//(1+2)+4 Expression
// SUm( Sum(Num(1), Num(2)), Num(4))


//재귀적사용법
fun evalWithLogging(e: Expr) : Int =
    when (e){
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown Exception")
    }
fun main(args : Array<String>){
    println( eval(Sum(Sum(Num(1), Num(2)) ,Num(4)  )) )

    println( eval2( Sum(Num(1), Num(2))))

    println( eval3( Sum(Num(1),Num(2))))

    println( evalWithLogging( Sum( Sum(Num(1),Num(2)), Num(4) )))
}