package com.kotlin.three

//3.5.3 여러줄 3중 따옴표 문자열
// 3중 따옴표 문자열로 줄바꿈을 표현하는 아무 문자열이나 그대로 들어간다.


fun main(args: Array<String>){
    val kotlinLog = """| // 
                        .| //
                        .|/\"""
    println(kotlinLog.trimMargin("."))
    println(kotlinLog)
}
//여러줄 문자열을 코드에서 더 좋게 표현하고 싶다면 들여쓰기를 하되 들여쓰기의 끝부분을 특별한 문자열로 표시하고, trimMargin을 사용해 그 문자열과 그 직전의
// 공백을 제거한다.
// 여러줄 문자열에서는 줄바꿈을 \n과 같은 특수문자를 사용해 넣을수 없다. 반면에 \를 문자열에 넣고싶으면 이스케이프할 필요가 없다.
// """C:\Users/yole\kotlin-book"""
// $를 넣으려면   val price = """${'$'}99.9"""