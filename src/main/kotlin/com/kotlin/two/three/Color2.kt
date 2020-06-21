package com.kotlin.two.three

enum class Color2( val r: Int,  val g : Int,  val b : Int) {  //상수의 프로퍼티를 정의한다
    RED(255,0,0), //각 상수를 생성할때 그에 따른 프로퍼티를 정한다.
    ORANGE(255,165,0),
    YELLOW(255,255,0),
    GREEN(0,255,0),
    BLUE(0,0,255)
    ;

    fun rgb() = (r*256+g)*256+b
}

// enum 상수 :  상수에 해당하는 프로퍼티값을 지정
// 코틀린에서 유일하게 ; 사용
// enum안에 메소드정의시 반드시 enum상수목록과 메소드정의사이에 세미콜론을 넣어야한다.
fun getMnemonic(color2 : Color2)=  //함수의 반환값으로 when사용
    when(color2){   //색이 특정enum상수와 같다면 그상수에 대응하는 문자열
        Color2.RED -> "Richard"
        Color2.ORANGE -> "Of"
        Color2.YELLOW -> "York"
        Color2.GREEN, Color2.BLUE -> "GreenBattle" //여러개값 사용시
        //break가 no need
    }


fun mix(c1: Color2, c2 : Color2) =
    when( setOf(c1, c2)){  //when의 분기조건 부분에 식을 넣을수 있다.
        setOf(
            Color2.RED,
            Color2.YELLOW
        ) -> Color2.ORANGE   //두색을 혼합하면 다른색깔 집합비교사용
        setOf(
            Color2.YELLOW,
            Color2.BLUE
        ) -> Color2.GREEN
        else -> throw Exception("Dirty Color")
    }
//set 집합, 순서는 무의미

// mix function refactoring
// 코드는 어려워지지만 성능을 더 향상시킨다. set이 여러번 호출되지 않는다. 가독성떨어진다.
fun mixOptimized(c1: Color2, c2 : Color2) =
    when {
        (c1 == Color2.RED && c2 == Color2.YELLOW) ||(c1 == Color2.YELLOW && c2 == Color2.RED) -> Color2.ORANGE
        (c1 == Color2.YELLOW && c2 == Color2.BLUE) ||(c1 == Color2.BLUE && c2 == Color2.YELLOW) -> Color2.GREEN
        else -> throw Exception("Dirty Color")
    }


fun main(args : Array<String>){
    println(Color2.GREEN)
    println(Color2.GREEN.rgb())
    println(getMnemonic(Color2.BLUE))
    println(
        mix(
            Color2.YELLOW,
            Color2.RED
        )
    )
    println(
        mixOptimized(
            Color2.RED,
            Color2.YELLOW
        )
    )

}
