package com.kotlin.four


// 4.4.3 동반객체를 일반 객체처럼 사용
// 동반객체는 클래스안에 정의된 일반객체

// list 4.27 동반객체에 이름붙이기
class Person01(val name: String){
    companion object Loader{ //동반객체에 이름을 붙인다.
        fun fromJSON(jsonText : String ) : Person01 {
            val data = jsonText.substringAfter(':')
            return Person01(data.removeSuffix("}")
                .replace("'","",true  )
            )
        }
    }
}

fun main (args : Array<String>){
    val person = Person01.Loader.fromJSON("{name : 'Ryan'}")
    println(person.name)

    val person2 = Person01.fromJSON("{name : 'Shin'}")
    println(person2.name)
}