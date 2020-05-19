package com.kotlin.two.one/*
ㅇ함수선언할때는 fun키워드를 사용한다.
ㅇ파라미터이름 뒤에 파라미터 타입을 쓴다.
ㅇ 함수를 최상위 수준에 정의할수 있다.(클래스안에 함수를 넣을필요가 없다.)
ㅇ 배열도 일반적인 클래스와 마찬가지. 배열처리를 위한 문법이 별도로 존재하지 않는다.
ㅇ System.out.println대신 println라고 쓴다.
ㅇ ;를 사용하지 않는다.
*/
fun main(args : Array<String>){
    println("Hello, world!")
     if(args.size > 0)
        print("${args[0]}")
    //println("Hello World" + com.kotlin.two.one.max2(2,3))
    //println(com.kotlin.two.getYearsToCompute)
}
// 함수이름 :com.kotlin.two.one.max, 파라미터목록(a: Int, b: Int) , 반환타입 : Int
fun max(a: Int, b: Int): Int{
    return if(a>b) a else b
}

//  < statement and expresion>
//  if : expression이다 statement가 아니다.
//  expression : 값을 만들어 내며 다른식의 하위 요소로 계산에 참여할수 있다.
//  statment : 가장안쪽블럭의 최상위요소로 존재 아무런값을 만들어내지 않는다.
//  Java : 모든 제어구조가 statement, Kotlin : 루프를 제외한 데부분의 제어구조가 expression

//간결하게 표현
fun max1(a: Int, b: Int): Int = if(a>b) a else b

//반환타입 생략
// 식이 본문인 함수는 사용자가 반환타입을 적지 않아도 컴파일러가 함수본문식을 해석해서 식의 결과타입을 함수 반환타입으로 정해준다. => 타입추론(type inference)
fun max2(a: Int, b: Int) = if(a > b) a else b

//2.1.3 변수
// 자바 : 변수선언시 타입이 맨앞에온다.
// 코틀린 : 타입지정을 생략해도 된다.
val question = "삶, 우주, 그리고 모든 것에 대한 궁극적인 질문"
val answer = 42
// 타입명시할때
val answer0 : Int = 42
// 변수타입은 더블
val yearsToCompute = 7.5e6

// ㅇ 변경가능한 변수와 변경불가능한 변수
// val - 변경불가능한 immutable 참조를 저장하는 변수, 자바의 final
// var - 변경가능한 mutable 참조. 자바의 일반변수
// 기본적으로 모든 변수를 val키워드를 사용해 불변변수로 선언, 나중에 필요할때만 var로 변경
// val변수는 블록을 실행할때 정확히 한번만 초기화
fun valTest(){
    //val 참조자체는 불변 But 참조가 가리키는 객체의 내부값은 변경될수 있다.
    val languages = arrayListOf("Java")  //불변참조를 선언한다.
    //languages = arrayListOf("Java1") //불변참조라 불가
    languages.add("Kotlin")
}
fun varTest(){
    // var 변수의 값을 변경할수있다. But 타입은 고정돼 바뀌지 않는다.
    var answer = 42
    answer = 43
    //com.kotlin.two.getAnswer = "no Answer"  //"Error : type misMatching"
}
// 컴파일러는 변수선언시점의 초기화식으로부터 변수타입을 추론, 변수선언 이후 변수 재대입이 이뤄질때는 이미 추론한 변수타입을 염두에두고 대입문의 타입을 검사.



