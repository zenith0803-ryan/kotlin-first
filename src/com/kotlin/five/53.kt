package com.kotlin.five

import java.io.File

fun main(args : Array<String>){
    // p225
    listOf(1,2,3,4).asSequence()
        .map { print("map($it)");it * it }
        .filter{ print("filter($it)"); it % 2 == 0}
        //아무값도 출력되지 않음 - map,filter 변환이 늦춰져서 결과를 얻을 필요가 있을때(최종연산이 호출될때) 적용된다는 뜻

    val list =  listOf(1,2,3,4).asSequence()
        .map { print("map($it)");it * it }
        .filter{ print("filter($it)"); it % 2 == 0}
        .toList()  // 시퀀스를 리스트로 만든다.

    println(list)

    println( listOf(1,2,3,4).asSequence().map { it * it }.find { it > 3 })

    //5.3.2 시퀀스만들기
    println("list 5.12 자연수의 시퀀스를 생성하고 사용하기")
    val naturalNumbers = generateSequence(0){it+1}
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100)
    println(numbersTo100.sum())
    println(numbersTo100.any())
    println(numbersTo100.count())
    println(numbersTo100.max())
    println(numbersTo100.min())

    println("list 5.13 상위디렉토리의 시퀀스를 생성하고 사용하기 ")
    fun File.isInsideHiddenDirectory() = generateSequence (this){ it.parentFile}.any{it.isHidden}
    val file = File("/Users/zenith/.HiddenDir/a.txt")
    println(file.isInsideHiddenDirectory())

    fun File.isInsideHiddenDirectory2() = generateSequence (this){ it.parentFile}.find{it.isHidden}
    val file2 = File("/Users/zenith/.HiddenDir/a.txt")
    println(file2.isInsideHiddenDirectory2())

}

