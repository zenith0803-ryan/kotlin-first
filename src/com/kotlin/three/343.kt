package com.kotlin.three

// 3.4.3 값의 쌍 다루기 : 중위호출과 구조분해선언

fun main(args: Array<String>){
    val map = mapOf(1 to "one", 2 to "two", 53 to "fifty-three")
    // 중위호출(infix call)이라는 방식으로  to라는 일반메소드를 호출

    1.to("one")  // to 메소드를 일반적인 방식으로 호출
    1 to "one"  // to 메소드를 중위호출방식으로 호출
    //인자가 하나뿐인 일반 메소드나 확장함수에 중위호출을 사용할수 있다.
    infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)  //Pair의 인스턴스를 반환, 두원소로 이루어진 순서쌍

    val (number, name) = 1 to "one"
    // 구조분해선언 destructuring declation
    // 1 to "one" to-> Pair(1, "one") -> val(1, "one")

    val collection = arrayListOf(1,7,53)
    for( (index, element) in collection.withIndex()){  //withIndex를 구조분해선언과 조합하면 컬렉션원소의 인덱스와 값을따로 변수에 담을수 있다.
        println("$index: $element")
    }

    //to를 사용하면 타입과 관계없이 임의의 순서쌍을 만들수있다.
}

