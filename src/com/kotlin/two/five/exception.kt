package com.kotlin.two.five

import java.io.BufferedReader
import java.io.StringReader

//코틀린의 예외처리는 자바와 비슷하다.

fun main(args: Array<String>){
    //기본예외처리구문은 자바와 비슷하다.
//    val percentage = 101
//    if(percentage  !in 0..100){
//        throw IllegalArgumentException("A percentage value must be between 0 and 100 : $percentage")  //new가 불필요, "thow"는 식이다
//    }
    val number = 10
    val percentage2 =
        if( number in 0..100)
            number
        else
            throw IllegalArgumentException("A percentage value must be between 0 and 100 : $number")

    // 2.5.1 try,catch, finally
    // 2.27 자바와 마찬가지로 try 사용하기
    fun readNumber( reader: BufferedReader) : Int?{  //함수가 던질수 있는 예외를 명시할 필요가 없다
        try{
            val line = reader.readLine()
            return Integer.parseInt(line)
        }catch( e: NumberFormatException){ //예외타입을 :의 오른쪽에 쓴다.
            return null
        }finally {      //자바와 동일
            reader.close()
        }
    }
    val reader = BufferedReader(StringReader("239"))
    println(reader)
    //자바와 차이는 throws절에 코드에 없는것!!
    //자바는 함수선언뒤에 throwsIOException을 붙여야한다. 자바는 체크 예외를 명시적으로 처리해야한다.
    // 어떤함수가 던질 가능성이 있는 예외나 그 함수가 호출한 다른 함수에서 발생할수 있는 예외를  catch로 처리 ..처리하지않으면 throws

    //코틀린에서는 함수가 던지는 예외를 지정하지 않고 발생한 예외를 잡아도되고 안잡아도됨.



}