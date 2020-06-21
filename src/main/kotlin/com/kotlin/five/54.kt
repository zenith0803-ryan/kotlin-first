package com.kotlin.five

import com.kotlin.four.State

interface View99 {
    val id : String
}

fun main(args: Array<String>){
    val button = Button()
    button.setOnClickListener{ view -> println(view.toString()) }

    button.postponeComputation(1000){  println(42)}
    button.postponeComputation(1000, object : Runnable{
        override fun run() {
            println(42)
        }
    })

    println("SAM생성자를 사용하여 값 반환하기")
    // SAM생성자를 사용하여 값 반환하기
    fun createAllDoneRunnable() : Runnable {
        return Runnable { println("All Done") }
    }
    createAllDoneRunnable().run()

    println("list 5.15 SAM생성자를 사용해 listnener 인스턴트 재사용하기")
    val listener = OnClickListener {  view ->
        val text = when(view.id){
            else -> "Unknown button"
        }
    }
    button.setOnClickListener(listener)

}