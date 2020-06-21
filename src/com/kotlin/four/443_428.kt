package com.kotlin.four

//list 4.28 동반객체에서 인터페이스 구현하기
interface JSONFactory<T>{
    fun fromJSON(jsonText: String) : T
}

class Person31(val name : String){
    companion object : JSONFactory<Person31>{
        override fun fromJSON(jsonText: String): Person31 {
           println(jsonText)
            return  Person31("you")
        }
    }
}

