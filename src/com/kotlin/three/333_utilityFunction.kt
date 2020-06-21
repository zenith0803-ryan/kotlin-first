package com.kotlin.three

// joinToString 최종버전
fun <T> Collection<T>.joinToString(  //Collection<T>에 대한 확장함수선언
    separator: String = ", ", //디폴트값 지정
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for((index,element) in this.withIndex()){ // this는 수신객체를 가리킨다
        if ( index > 0)  result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main(args : Array<String>){
    val list = listOf(1,2,3)
    println(list.joinToString(" "))


//    list.join(" ")
    //확장함수가 정적메소드와 같은 특징을 가지므로 확장함수를 하위클래스에서 오버라이드할수없다.
}

//문자열의 컬렉션에 대해서만 호출할수 있는 join함수를 정의
fun  Collection<Int>.join(  //Collection<T>에 대한 확장함수선언
    separator: String = ", ", //디폴트값 지정
    prefix: String = "",
    postfix: String = ""
) = joinToString( separator, prefix, postfix)