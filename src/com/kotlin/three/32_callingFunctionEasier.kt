package com.kotlin.three

import strings.joinToString3

fun main(args : Array<String>){
    //자바컬렉션에 디폴트 toString이 있는데 이건 우리에게 필요한 형식이 아닐수있다
    val list = listOf(1,2,3)
    println(list)  //toString()호출
    //  다르게 만들고싶다면..
    // 이번절엔 그런 함수를 구현해보자.

    // joinToSting Test
    println(joinToString(list, ";", "(", ")"))
    // 3.2.1 이름붙인 인자.
    // 아래를 보자 가독성이 좋다
    // 함수에 전달하는 인자중 일부의 이름을 명시할수 있다.
    println(joinToString(collection = list
        ,separator = ";"
        ,prefix = "("
        ,postfix = ")")
    )
    // 경고 : 불행이도 자바코드를 호출할때 이름붙인 인자를 사용할수없다.
    // 코틀린은 JDK6와 호환된다. 그 결과 코틀린 컴파일러는 함수 시그니처의 파라미터 이름을 인식할수 없다.

    // 3.2.2 디폴트 파라미터 값
    // 자바문제점 - 일부클래스에서 overloading 한 메소드가 너무 많다ㅠㅠ
    // 오버로딩함수에 대해 대부분의 설명을 반복해 달아야 한다 ㅠㅠ(친절한 개발자 생활)
    // joinToString개선
    println( joinToString2(list))

    // 3.2.3 정적인 유틸리티 클래스 없애기 : 최상위 함수와 프로퍼티
    //자바 : 모든 코드를 클래스의 메소드로 작성한다. but  실전에서 어느한클래스에 포함시키기 어려울때도 있다.
    // 그결과 다양한 정적메소드를 모아두는 역할만 담당하고 특별한상태나 인스턴스메소드는 없는 클래스가 생겨난다 ex)Collections
    // 코틀린은 이런 무의미한 클래스가 필요없다. 대신 함수를 직접 소스파일의 최상위수준, 모든 다른클래스의 밖에 위치시키면된다.
    // 그런 함수들은 맨앞에 정의된 패키지 멤버함수
    // 다른패키지에서 사용하려면 그 함수가 정의된 패키지를 임포트해야한다.
    // strings패키지의  topFunctions.kt를 보자

    println(joinToString3(list))


    // 최상위 프로퍼티
    performOperation()
    reportOperationCount()
    //이런프로퍼티 값은 정적필드에 저장된다.
    //최상위 프로퍼티를 활용해 코드에 상수를 추가할수 있다.



}
val UNIX_LINE_SEPRATOR= "\n"
// 더 자연스럽게 사용하려면 public static final필드로 컴파일해야한다.
const val UNIX_LINE_SEPRATOR2= "\n"
//java
//public static final String UNIX_LINE_SEPRATOR2= "\n"




//joinToString함수는 컬렉션의 원소를 StringBuilder뒤에 덧붙인다.
// 원소사이에 구분자를 넣고, 맨앞에 접두사, 맨뒤에 접미사를 추가한다.
fun<T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
): String {
    val result = StringBuilder(prefix)
    for ( (index, element) in collection.withIndex()){
        if( index > 0 ) result.append(separator)  //첫원소앞에는 구분자를 넣으면 안되요
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
// 이함수는 generic - 어떤타입의 값을 원소로하는 컬렉션이든 처리할수 있다.
//


//함수 디폴트 파라미터값은 함수를 선언하는쪽에서 지정된다!!
// 따라서 어떤 클래스안에 정의된 함수의 디폴트값을 바꾸고 재컴파일하면 호출하는 코드중에 값을 지정하지 않은 모든 인자는 디폴트값 적용을 받는다.
fun<T> joinToString2(
    collection: Collection<T>,
    separator: String = ", ",  //디폴트값이 지정된 파라미터들
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ( (index, element) in collection.withIndex()){
        if( index > 0 ) result.append(separator)  //첫원소앞에는 구분자를 넣으면 안되요
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

var opCount = 0
fun performOperation(){
    opCount++
}
fun reportOperationCount(){
    println("Operation perfored $opCount times")
}