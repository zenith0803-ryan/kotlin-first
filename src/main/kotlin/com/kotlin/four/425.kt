package com.kotlin.four

//4.2.5 접근자의 가시성 변경


// list 4.16 비공개 세터가 있는 프로퍼티 선언하기
class LengthCounter{
    var counter : Int = 0
        private set      // 이클래스 밖에서 이 프로퍼티의 값을 바꿀수없다.
    fun addWord(word: String){
        counter += word.length
    }
}

fun main(args : Array<String>){
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Strike!")
    println(lengthCounter.counter)
    //lengthCounter.counter = 1
    //println(lengthCounter.counter)
}